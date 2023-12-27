package github.polarisink.vgq.application;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.google.common.util.concurrent.RateLimiter;
import github.polarisink.vgq.domain.answer.Answer;
import github.polarisink.vgq.domain.answer.AnswerRepo;
import github.polarisink.vgq.domain.answer.AnswerSubmitReq;
import github.polarisink.vgq.domain.answer.ExportProperties;
import github.polarisink.vgq.domain.sort.AnswerSort;
import github.polarisink.vgq.domain.sort.AnswerSortRepo;
import github.polarisink.vgq.infrastructure.asserts.AssertUtil;
import github.polarisink.vgq.infrastructure.utils.ContentUtil;
import github.polarisink.vgq.infrastructure.utils.CountryAndRegionUtil;
import github.polarisink.vgq.infrastructure.utils.TimeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dreamlu.mica.ip2region.core.Ip2regionSearcher;
import net.dreamlu.mica.ip2region.core.IpInfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;

import static github.polarisink.vgq.infrastructure.asserts.BusinessE.PASSWORD_ERROR;
import static github.polarisink.vgq.infrastructure.utils.FileUtils.buildAttachment;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

/**
 * @author lqsgo
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AnswerService {
  private final AnswerSortRepo answerSortRepo;
  private static final String EXCEL_CONTENT_TYPE = "application/vnd.ms-excel;charset=UTF-8";

  private final Ip2regionSearcher ip2regionSearcher;
  private final AnswerRepo answerRepo;
  private final ExportProperties properties;
  private final RateLimiter submitRateLimiter = RateLimiter.create(5);
  private final RateLimiter exportRateLimiter = RateLimiter.create(3);
  private final RateLimiter clearRateLimiter = RateLimiter.create(1);


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
    Answer answer = req.convert(ip, countryEn);
    answerRepo.save(answer);
    AnswerSort first = answerSortRepo.findFirst();
    first.update(answer.classify);
    answerSortRepo.save(first);
  }


  public void export(Integer index, String password, HttpServletResponse response) throws IOException {
    if (!exportRateLimiter.tryAcquire()) {
      tooFrequentThrow();
    }
    AssertUtil.equals(password, properties.getPassword(), PASSWORD_ERROR);
    //TODO 流写入，防止数据太大OOM
    List<Answer> answerList = index == null ? answerRepo.findAll() : answerRepo.findByClassify(index);
    String[] nameArray = index == null ? new String[]{properties.getSheet(), TimeUtil.format2day(LocalDateTime.now()), ".csv"} : new String[]{properties.getSheet(), index.toString(), TimeUtil.format2day(LocalDateTime.now()), ".csv"};
    String sheet = StrUtil.join("-", nameArray);
    ServletOutputStream outputStream = response.getOutputStream();
    response.setContentType(EXCEL_CONTENT_TYPE);
    response.setCharacterEncoding(StandardCharsets.UTF_8.name());
    response.setHeader(CONTENT_DISPOSITION, buildAttachment(sheet));
    EasyExcel.write(outputStream).head(Answer.class).excelType(ExcelTypeEnum.CSV).sheet(sheet).doWrite(answerList);
    IoUtil.close(outputStream);
  }

  @Transactional(readOnly = true)
  public int index() {
    AnswerSort sort = answerSortRepo.findFirst();
    return sort.minIndex();
  }

  /**
   * 太频繁抛异常
   */
  private void tooFrequentThrow() {
    throw new RuntimeException(properties.getFrequentMsg());
  }

  public void clear(String password) {
    if (!clearRateLimiter.tryAcquire()) {
      tooFrequentThrow();
    }
    AssertUtil.equals(password, properties.getPassword(), PASSWORD_ERROR);
    answerRepo.deleteAll();
  }
}