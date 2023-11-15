package github.polarisink.vgq.application;

import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.google.common.util.concurrent.RateLimiter;
import github.polarisink.vgq.domain.answer.*;
import github.polarisink.vgq.infrastructure.asserts.AssertUtil;
import github.polarisink.vgq.infrastructure.utils.ContentUtil;
import github.polarisink.vgq.infrastructure.utils.CountryAndRegionUtil;
import github.polarisink.vgq.infrastructure.utils.TimeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dreamlu.mica.ip2region.core.Ip2regionSearcher;
import net.dreamlu.mica.ip2region.core.IpInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static github.polarisink.vgq.infrastructure.asserts.BusinessE.PASSWORD_ERROR;

/**
 * @author lqsgo
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AnswerService {
  private static final String EXCEL_CONTENT_TYPE = "application/vnd.ms-excel;charset=UTF-8";

  private final Ip2regionSearcher ip2regionSearcher;
  private final AnswerRepo answerRepo;
  private final ExportProperties properties;
  private final RateLimiter submitRateLimiter = RateLimiter.create(5);
  private final RateLimiter exportRateLimiter = RateLimiter.create(3);

  @Transactional(rollbackFor = Exception.class)
  public void submit(AnswerSubmitReq req) {
    if (!submitRateLimiter.tryAcquire()) {
      tooFrequentThrow();
    }
    //TODO 业务
    String ip = ContentUtil.getClientIp();
    IpInfo ipInfo = ip2regionSearcher.memorySearch(ip);
    String country = ipInfo == null || StrUtil.isBlank(ipInfo.getCountry()) ? "美国" : ipInfo.getCountry();
    String countryEn = CountryAndRegionUtil.getEnByCn(country);
    AnswerSubmitReq.FirstSubmitItem first = req.getStart();
    AnswerSubmitReq.SecondSubmitItem second = req.getFirst();
    AnswerSubmitReq.SecondSubmitItem third = req.getSecond();
    AnswerSubmitReq.LastSubmitItem last = req.getLast();
    LocalDateTime submitTime = LocalDateTime.now();
    LocalDateTime startTime = req.getStartTime();
    Answer answer = new Answer()
        .setAge(first.getAge()).setStartTime(startTime).setSubmitTime(submitTime)
        .setIp(ip).setRegion(countryEn).setDuration(Duration.between(startTime, submitTime).getSeconds())
        .setStartCheckRadio(first.getCheckRadio()).setStartQuest1(first.getQuest1()).setStartQuest2(first.getQuest2())
        .setStartQuest3(first.getQuest3()).setStartQuest4(first.getQuest4()).setStartQuest5(first.getQuest5())
        .setFirstItemOne(second.getItemOne()).setFirstQuest1(second.getQuest1()).setFirstQuest2(second.getQuest2())
        .setFirstQuest3(second.getQuest3()).setSecondItemOne(third.getItemOne()).setSecondQuest1(third.getQuest1())
        .setSecondQuest2(third.getQuest2()).setSecondQuest3(third.getQuest3()).setLastQuest1(last.getQuest1())
        .setLastQuest2(last.getQuest2()).setLastQuest3(last.getQuest3()).setLastOtherComments(last.getOtherComments());
    answerRepo.save(answer);
  }


  public void export(String password, HttpServletResponse response) {
    if (!exportRateLimiter.tryAcquire()) {
      tooFrequentThrow();
    }
    AssertUtil.equals(password, properties.getPassword(), PASSWORD_ERROR);
    //TODO 流写入，防止数据太大OOM
    long count = answerRepo.count();
    List<Answer> answerList = answerRepo.findAll();
    String sheet = properties.getSheet() + "-" + TimeUtil.format2day(LocalDateTime.now());
    try (ServletOutputStream outputStream = response.getOutputStream()) {
      response.setContentType(EXCEL_CONTENT_TYPE);
      response.setCharacterEncoding(StandardCharsets.UTF_8.name());
      String fileName = URLEncoder.encode(sheet, StandardCharsets.UTF_8) + ".csv";
      response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
      EasyExcel.write(outputStream).head(Answer.class).excelType(ExcelTypeEnum.CSV).sheet(sheet).doWrite(answerList);
    } catch (IOException e) {
      LOG.error("导出csv数据失败,{}", e.getMessage());
      throw new RuntimeException("export csv file failed");
    }
  }

  /**
   * 太频繁抛异常
   */
  public void tooFrequentThrow() {
    throw new RuntimeException(properties.getFrequentMsg());
  }
}