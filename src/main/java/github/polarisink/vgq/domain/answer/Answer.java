package github.polarisink.vgq.domain.answer;

import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import com.alibaba.excel.enums.BooleanEnum;
import com.alibaba.excel.enums.poi.HorizontalAlignmentEnum;
import com.alibaba.excel.enums.poi.VerticalAlignmentEnum;
import github.polarisink.vgq.domain.base.BaseJpaEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author lqsgo
 */
@Table
@Entity
@HeadStyle(horizontalAlignment = HorizontalAlignmentEnum.LEFT, verticalAlignment = VerticalAlignmentEnum.CENTER, wrapped = BooleanEnum.TRUE)
@ContentStyle(horizontalAlignment = HorizontalAlignmentEnum.LEFT, verticalAlignment = VerticalAlignmentEnum.CENTER, wrapped = BooleanEnum.TRUE)
public class Answer extends BaseJpaEntity {
  @Column(columnDefinition = "varchar(128)")
  public String ip;
  @Column(columnDefinition = "varchar(128)")
  public String region;
  //分组
  public Integer num;
  //first
  //question1
  @Column(columnDefinition = "varchar(128)")
  public String startTq01;
  @Column(columnDefinition = "varchar(128)")
  public String startTq02;
  @Column(columnDefinition = "varchar(128)")
  public String startTq03;
  @Column(columnDefinition = "varchar(128)")
  public String startTq04;
  @Column(columnDefinition = "varchar(128)")
  public String startTq05;
  @Column(columnDefinition = "varchar(128)")
  public String startTq11;
  @Column(columnDefinition = "varchar(128)")
  public String startTq12;
  @Column(columnDefinition = "varchar(128)")
  public String startTq13;
  @Column(columnDefinition = "varchar(128)")
  public String startTq14;
  @Column(columnDefinition = "varchar(128)")
  public String startTq15;
  @Column(columnDefinition = "varchar(128)")
  public String startTq16;
  @Column(columnDefinition = "varchar(128)")
  public String startTq17;
  //question2
  @Column(columnDefinition = "varchar(128)")
  public String startTq21;
  @Column(columnDefinition = "varchar(128)")
  public String startTq22;
  @Column(columnDefinition = "varchar(128)")
  public String startTq23;
  @Column(columnDefinition = "varchar(128)")
  public String startTq24;
  @Column(columnDefinition = "varchar(128)")
  public String startTq25;
  @Column(columnDefinition = "varchar(128)")
  public String startTq26;
  @Column(columnDefinition = "varchar(128)")
  public String startTq27;
  @Column(columnDefinition = "varchar(128)")
  public String startTq28;
  @Column(columnDefinition = "varchar(128)")
  public String startTq29;
  @Column(columnDefinition = "varchar(128)")
  public String startTq210;
  @Column(columnDefinition = "varchar(128)")
  public String startTq211;
  //question3
  @Column(columnDefinition = "varchar(128)")
  public String startTq31;
  @Column(columnDefinition = "varchar(128)")
  public String startTq32;
  @Column(columnDefinition = "varchar(128)")
  public String startTq33;
  @Column(columnDefinition = "varchar(128)")
  public String startTq34;
  @Column(columnDefinition = "varchar(128)")
  public String startTq35;
  @Column(columnDefinition = "varchar(128)")
  public String startTq36;
  @Column(columnDefinition = "varchar(128)")
  public String startTq37;
  @Column(columnDefinition = "varchar(128)")
  public String startTq38;
  @Column(columnDefinition = "varchar(128)")
  public String startTq39;
  @Column(columnDefinition = "varchar(128)")
  public String startTq310;
  @Column(columnDefinition = "varchar(128)")
  public String startTq311;
  @Column(columnDefinition = "varchar(128)")
  public String startTq312;
  @Column(columnDefinition = "varchar(128)")
  public String startTq313;
  //question4
  @Column(columnDefinition = "varchar(128)")
  public String startTq41;
  @Column(columnDefinition = "varchar(128)")
  public String startTq42;
  @Column(columnDefinition = "varchar(128)")
  public String startTq43;
  @Column(columnDefinition = "varchar(128)")
  public String startTq44;
  @Column(columnDefinition = "varchar(128)")
  public String startTq45;
  @Column(columnDefinition = "varchar(128)")
  public String startTq46;
  @Column(columnDefinition = "varchar(128)")
  public String startTq47;

  //last
  @Column(columnDefinition = "varchar(128)")
  public String lastTq1;
  @Column(columnDefinition = "varchar(128)")
  public String lastTq2;
  @Column(columnDefinition = "varchar(128)")
  public String lastTq3;
  @Column(columnDefinition = "varchar(128)")
  public String lastTq4;
  @Column(columnDefinition = "varchar(128)")
  public String lastTq5;
  @Column(columnDefinition = "varchar(128)")
  public String lastTq6;
  @Column(columnDefinition = "varchar(128)")
  public String lastTq7;
  @Column(columnDefinition = "varchar(128)")
  public String lastTq8;
  public Integer age;
  @Column(columnDefinition = "varchar(128)")
  public String radio1;
  @Column(columnDefinition = "varchar(128)")
  public String radio2;
  @Column(columnDefinition = "varchar(128)")
  public String radio3;
  @Column(columnDefinition = "varchar(128)")
  public String radio4;
  @Column(columnDefinition = "varchar(128)")
  public String radio5;
  @Column(columnDefinition = "varchar(128)")
  public String otherComments;

  //game
  //game1
  @Column(columnDefinition = "varchar(128)")
  public String game1Tq01;
  @Column(columnDefinition = "varchar(128)")
  public String game1Tq02;
  @Column(columnDefinition = "varchar(128)")
  public String game1Tq03;
  @Column(columnDefinition = "varchar(128)")
  public String game1Tq11;
  @Column(columnDefinition = "varchar(128)")
  public String game1Tq12;
  @Column(columnDefinition = "varchar(128)")
  public String game1Tq13;
  public Integer game1Item;
  //game2
  @Column(columnDefinition = "varchar(128)")
  public String game2Tq01;
  @Column(columnDefinition = "varchar(128)")
  public String game2Tq02;
  @Column(columnDefinition = "varchar(128)")
  public String game2Tq03;
  @Column(columnDefinition = "varchar(128)")
  public String game2Tq11;
  @Column(columnDefinition = "varchar(128)")
  public String game2Tq12;
  @Column(columnDefinition = "varchar(128)")
  public String game2Tq13;
  public Integer game2Item;
 //game3
  @Column(columnDefinition = "varchar(128)")
  public String game3Tq01;
  @Column(columnDefinition = "varchar(128)")
  public String game3Tq02;
  @Column(columnDefinition = "varchar(128)")
  public String game3Tq03;
  @Column(columnDefinition = "varchar(128)")
  public String game3Tq11;
  @Column(columnDefinition = "varchar(128)")
  public String game3Tq12;
  @Column(columnDefinition = "varchar(128)")
  public String game3Tq13;
  public Integer game3Item;
  //game4
  @Column(columnDefinition = "varchar(128)")
  public String game4Tq01;
  @Column(columnDefinition = "varchar(128)")
  public String game4Tq02;
  @Column(columnDefinition = "varchar(128)")
  public String game4Tq03;
  @Column(columnDefinition = "varchar(128)")
  public String game4Tq11;
  @Column(columnDefinition = "varchar(128)")
  public String game4Tq12;
  @Column(columnDefinition = "varchar(128)")
  public String game4Tq13;
  public Integer game4Item;
}
