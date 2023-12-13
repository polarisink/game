package github.polarisink.vgq.domain.answer;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import com.alibaba.excel.enums.BooleanEnum;
import com.alibaba.excel.enums.poi.HorizontalAlignmentEnum;
import com.alibaba.excel.enums.poi.VerticalAlignmentEnum;
import github.polarisink.vgq.domain.base.BaseJpaEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author lqsgo
 */
@Data
@Table
@Entity
@HeadStyle(horizontalAlignment = HorizontalAlignmentEnum.LEFT, verticalAlignment = VerticalAlignmentEnum.CENTER, wrapped = BooleanEnum.TRUE)
@ContentStyle(horizontalAlignment = HorizontalAlignmentEnum.LEFT, verticalAlignment = VerticalAlignmentEnum.CENTER, wrapped = BooleanEnum.TRUE)
public class Answer extends BaseJpaEntity {
  @ExcelProperty("Age")
  @Column(columnDefinition = "int not null comment '年龄（0到150）'")
  private Integer age;
  @ExcelProperty(value = "StartDate")
  @Column(columnDefinition = "datetime not null comment '开始回答的时间'")
  private LocalDateTime startTime;
  @Column(columnDefinition = "datetime not null comment '提交答案的时间'")
  @ExcelProperty(value = "EndDate")
  private LocalDateTime submitTime;
  @ExcelProperty("Duration(in seconds)")
  @Column(columnDefinition = "bigint not null comment '持续时间'")
  private Long duration;
  @ExcelProperty("IpAddress")
  @Column(columnDefinition = "varchar(64) not null comment 'ip'")
  private String ip;
  @ExcelProperty("Region")
  @Column(columnDefinition = "varchar(64) not null comment '地区'")
  private String region;
  /**
   * 下面是具体数据===================
   */
  private String startCheckRadio;
  private Integer startQuest1;
  private Integer startQuest2;
  private Integer startQuest3;
  private Integer startQuest4;
  private Integer startQuest5;
  private Integer firstItemOne;
  private Integer firstQuest1;
  private Integer firstQuest2;
  private Integer firstQuest3;
  private Integer secondItemOne;
  private Integer secondQuest1;
  private Integer secondQuest2;
  private Integer secondQuest3;
  private Integer lastQuest1;
  private Integer lastQuest2;
  private Integer lastQuest3;
  private String lastOtherComments;

  public static Answer convert(AnswerSubmitReq req, String ip, String countryEn) {
    AnswerSubmitReq.FirstSubmitItem first = req.getStart();
    AnswerSubmitReq.SecondSubmitItem second = req.getFirst();
    AnswerSubmitReq.SecondSubmitItem third = req.getSecond();
    AnswerSubmitReq.LastSubmitItem last = req.getLast();
    LocalDateTime submitTime = LocalDateTime.now();
    LocalDateTime startTime = req.getStartTime();
    return new Answer()
        .setIp(ip).setRegion(countryEn).setDuration(Duration.between(startTime, submitTime).getSeconds())
        .setAge(first.getAge()).setStartTime(startTime).setSubmitTime(submitTime)
        .setStartCheckRadio(first.getCheckRadio()).setStartQuest1(first.getQuest1()).setStartQuest2(first.getQuest2())
        .setStartQuest3(first.getQuest3()).setStartQuest4(first.getQuest4()).setStartQuest5(first.getQuest5())
        .setFirstItemOne(second.getItemOne()).setFirstQuest1(second.getQuest1()).setFirstQuest2(second.getQuest2())
        .setFirstQuest3(second.getQuest3()).setSecondItemOne(third.getItemOne()).setSecondQuest1(third.getQuest1())
        .setSecondQuest2(third.getQuest2()).setSecondQuest3(third.getQuest3()).setLastQuest1(last.getQuest1())
        .setLastQuest2(last.getQuest2()).setLastQuest3(last.getQuest3()).setLastOtherComments(last.getOtherComments());
  }
}
