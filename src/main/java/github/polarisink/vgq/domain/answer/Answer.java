package github.polarisink.vgq.domain.answer;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import com.alibaba.excel.enums.BooleanEnum;
import com.alibaba.excel.enums.poi.HorizontalAlignmentEnum;
import com.alibaba.excel.enums.poi.VerticalAlignmentEnum;
import github.polarisink.vgq.domain.base.BaseJpaEntity;
import github.polarisink.vgq.infrastructure.BaseDateConverter;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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
}
