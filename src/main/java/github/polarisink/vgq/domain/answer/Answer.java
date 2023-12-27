package github.polarisink.vgq.domain.answer;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import com.alibaba.excel.enums.BooleanEnum;
import com.alibaba.excel.enums.poi.HorizontalAlignmentEnum;
import com.alibaba.excel.enums.poi.VerticalAlignmentEnum;
import github.polarisink.vgq.domain.base.BaseJpaEntity;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author lqsgo
 */
@Getter
@Table
@Entity
@HeadStyle(horizontalAlignment = HorizontalAlignmentEnum.LEFT, verticalAlignment = VerticalAlignmentEnum.CENTER, wrapped = BooleanEnum.TRUE)
@ContentStyle(horizontalAlignment = HorizontalAlignmentEnum.LEFT, verticalAlignment = VerticalAlignmentEnum.CENTER, wrapped = BooleanEnum.TRUE)
public class Answer extends BaseJpaEntity {
  private static final String varchar128 = "varchar(128)";
  @Column(columnDefinition = varchar128)
  public String ip;
  @Column(columnDefinition = varchar128)
  public String region;

  public LocalDateTime startTime;
  public LocalDateTime endTime;
  //分组
  @ExcelIgnore
  public Integer classify;
  //first
  //question1
  @Column(columnDefinition = varchar128)
  public String startTq01;
  @Column(columnDefinition = varchar128)
  public String startTq02;
  @Column(columnDefinition = varchar128)
  public String startTq03;
  @Column(columnDefinition = varchar128)
  public String startTq04;
  @Column(columnDefinition = varchar128)
  public String startTq05;
  @Column(columnDefinition = varchar128)
  public String startTq11;
  @Column(columnDefinition = varchar128)
  public String startTq12;
  @Column(columnDefinition = varchar128)
  public String startTq13;
  @Column(columnDefinition = varchar128)
  public String startTq14;
  @Column(columnDefinition = varchar128)
  public String startTq15;
  @Column(columnDefinition = varchar128)
  public String startTq16;
  @Column(columnDefinition = varchar128)
  public String startTq17;

  @Column(columnDefinition = varchar128)
  public String startTq18;
  @Column(columnDefinition = varchar128)
  public String startTq19;
  @Column(columnDefinition = varchar128)
  public String startTq110;
  @Column(columnDefinition = varchar128)
  public String startTq111;
  @Column(columnDefinition = varchar128)
  public String startTq112;

  //question2
  @Column(columnDefinition = varchar128)
  public String startTq21;
  @Column(columnDefinition = varchar128)
  public String startTq22;
  @Column(columnDefinition = varchar128)
  public String startTq23;
  @Column(columnDefinition = varchar128)
  public String startTq24;
  @Column(columnDefinition = varchar128)
  public String startTq25;
  @Column(columnDefinition = varchar128)
  public String startTq26;
  @Column(columnDefinition = varchar128)
  public String startTq27;
  @Column(columnDefinition = varchar128)
  public String startTq28;
  @Column(columnDefinition = varchar128)
  public String startTq29;
  @Column(columnDefinition = varchar128)
  public String startTq210;
  @Column(columnDefinition = varchar128)
  public String startTq211;
  @Column(columnDefinition = varchar128)
  public String startTq212;
  @Column(columnDefinition = varchar128)
  public String startTq213;

  //last
  @Column(columnDefinition = varchar128)
  public String lastTq1;
  @Column(columnDefinition = varchar128)
  public String lastTq2;
  @Column(columnDefinition = varchar128)
  public String lastTq3;
  @Column(columnDefinition = varchar128)
  public String lastTq4;
  @Column(columnDefinition = varchar128)
  public String lastTq5;
  @Column(columnDefinition = varchar128)
  public String lastTq6;
  @Column(columnDefinition = varchar128)
  public String lastTq7;
  @Column(columnDefinition = varchar128)
  public String lastTq8;
  public Integer age;
  @Column(columnDefinition = varchar128)
  public String radio1;
  @Column(columnDefinition = varchar128)
  public String radio2;
  @Column(columnDefinition = varchar128)
  public String radio3;
  @Column(columnDefinition = varchar128)
  public String radio4;
  @Column(columnDefinition = varchar128)
  public String radio5;
  @Column(columnDefinition = varchar128)
  public String otherComments;

  //game
  //game1
  public Integer game1Code;
  @Column(columnDefinition = varchar128)
  public String game1Tq01;
  @Column(columnDefinition = varchar128)
  public String game1Tq02;
  @Column(columnDefinition = varchar128)
  public String game1Tq11;
  @Column(columnDefinition = varchar128)
  public String game1Tq12;
  @Column(columnDefinition = varchar128)
  public String game1Tq13;
  @Column(columnDefinition = varchar128)
  public String game1Tq21;
  @Column(columnDefinition = varchar128)
  public String game1Tq22;
  @Column(columnDefinition = varchar128)
  public String game1Tq23;
  //game2
  public Integer game2Code;

  @Column(columnDefinition = varchar128)
  public String game2Tq01;
  @Column(columnDefinition = varchar128)
  public String game2Tq02;
  @Column(columnDefinition = varchar128)
  public String game2Tq03;
  @Column(columnDefinition = varchar128)
  public String game2Tq11;
  @Column(columnDefinition = varchar128)
  public String game2Tq12;
  @Column(columnDefinition = varchar128)
  public String game2Tq13;
  @Column(columnDefinition = varchar128)
  public String game2Tq21;
  @Column(columnDefinition = varchar128)
  public String game2Tq22;
  @Column(columnDefinition = varchar128)
  public String game2Tq23;
  //game3
  public Integer game3Code;

  @Column(columnDefinition = varchar128)
  public String game3Tq01;
  @Column(columnDefinition = varchar128)
  public String game3Tq02;
  @Column(columnDefinition = varchar128)
  public String game3Tq03;
  @Column(columnDefinition = varchar128)
  public String game3Tq11;
  @Column(columnDefinition = varchar128)
  public String game3Tq12;
  @Column(columnDefinition = varchar128)
  public String game3Tq13;
  @Column(columnDefinition = varchar128)
  public String game3Tq21;
  @Column(columnDefinition = varchar128)
  public String game3Tq22;
  @Column(columnDefinition = varchar128)
  public String game3Tq23;
  //game4
  public Integer game4Code;
  @Column(columnDefinition = varchar128)
  public String game4Tq01;
  @Column(columnDefinition = varchar128)
  public String game4Tq02;
  @Column(columnDefinition = varchar128)
  public String game4Tq03;
  @Column(columnDefinition = varchar128)
  public String game4Tq11;
  @Column(columnDefinition = varchar128)
  public String game4Tq12;
  @Column(columnDefinition = varchar128)
  public String game4Tq13;
  @Column(columnDefinition = varchar128)
  public String game4Tq21;
  @Column(columnDefinition = varchar128)
  public String game4Tq22;
  @Column(columnDefinition = varchar128)
  public String game4Tq23;

}
