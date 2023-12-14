package github.polarisink.vgq.domain.answer;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AnswerSubmitReq {
  private int index;
  private StartQuestionnaireDTO startQuestionnaire;
  private AfterGameQues1DTO afterGameQues1;
  private AfterGameQues1DTO afterGameQues2;
  private AfterGameQues1DTO afterGameQues3;
  private AfterGameQues1DTO afterGameQues4;
  private LastQuestionnaireDTO lastQuestionnaire;

  @NoArgsConstructor
  @Data
  public static class StartQuestionnaireDTO {
    private Table0DTO table0;
    private Table1DTO table1;
    private Table2DTO table2;
    private Table3DTO table3;
    private Table4DTO table4;

    @NoArgsConstructor
    @Data
    public static class Table0DTO {
      private String quest1;
      private String quest2;
      private String quest3;
      private String quest4;
      private String quest5;
    }

    @NoArgsConstructor
    @Data
    public static class Table1DTO {
      private String quest1;
      private String quest2;
      private String quest3;
      private String quest4;
      private String quest5;
      private String quest6;
      private String quest7;
    }

    @NoArgsConstructor
    @Data
    public static class Table2DTO {
      private String quest1;
      private String quest2;
      private String quest3;
      private String quest4;
      private String quest5;
      private String quest6;
      private String quest7;
      private String quest8;
      private String quest9;
      private String quest10;
      private String quest11;
    }

    @NoArgsConstructor
    @Data
    public static class Table3DTO {

      private String quest1;

      private String quest2;

      private String quest3;

      private String quest4;

      private String quest5;

      private String quest6;

      private String quest7;

      private String quest8;

      private String quest9;
      private String quest10;
      private String quest11;
      private String quest12;
      private String quest13;
    }

    @NoArgsConstructor
    @Data
    public static class Table4DTO {

      private String quest1;

      private String quest2;

      private String quest3;

      private String quest4;

      private String quest5;

      private String quest6;

      private String quest7;
    }
  }

  @NoArgsConstructor
  @Data
  public static class AfterGameQues1DTO {
    private TableDTO table0;
    private TableDTO table1;
    private Integer itemOne;

    @NoArgsConstructor
    @Data
    public static class TableDTO {

      private String quest1;

      private String quest2;

      private String quest3;
    }

  }


  @NoArgsConstructor
  @Data
  public static class LastQuestionnaireDTO {
    private TableDTO table;
    private Integer age;
    private String radio1;
    private String radio2;
    private String radio3;
    private String radio4;
    private String otherComments;
    private String radio5;

    @NoArgsConstructor
    @Data
    public static class TableDTO {

      private String quest1;

      private String quest2;

      private String quest3;

      private String quest4;

      private String quest5;

      private String quest6;

      private String quest7;

      private String quest8;
    }
  }

  public Answer convert(String ip,String region) {
    Answer answer = new Answer();
    answer.num = index;
    answer.ip = ip;
    answer.region = region;
    //具体数据
    StartQuestionnaireDTO.Table0DTO table0 = startQuestionnaire.table0;
    answer.startTq01 = table0.quest1;
    answer.startTq02 = table0.quest2;
    answer.startTq03 = table0.quest3;
    answer.startTq04 = table0.quest4;
    answer.startTq05 = table0.quest5;
    StartQuestionnaireDTO.Table1DTO table1 = startQuestionnaire.table1;
    answer.startTq11 = table1.quest1;
    answer.startTq12 = table1.quest2;
    answer.startTq13 = table1.quest3;
    answer.startTq14 = table1.quest4;
    answer.startTq15 = table1.quest5;
    answer.startTq16 = table1.quest6;
    answer.startTq17 = table1.quest7;
    StartQuestionnaireDTO.Table2DTO table2 = startQuestionnaire.table2;
    answer.startTq21 = table2.quest1;
    answer.startTq22 = table2.quest2;
    answer.startTq23 = table2.quest3;
    answer.startTq24 = table2.quest4;
    answer.startTq25 = table2.quest5;
    answer.startTq26 = table2.quest6;
    answer.startTq27 = table2.quest7;
    answer.startTq28 = table2.quest8;
    answer.startTq29 = table2.quest9;
    answer.startTq210 = table2.quest10;
    answer.startTq211 = table2.quest11;
    StartQuestionnaireDTO.Table3DTO table3 = startQuestionnaire.table3;
    answer.startTq31 = table3.quest1;
    answer.startTq32 = table3.quest2;
    answer.startTq33 = table3.quest3;
    answer.startTq34 = table3.quest4;
    answer.startTq35 = table3.quest5;
    answer.startTq36 = table3.quest6;
    answer.startTq37 = table3.quest7;
    answer.startTq38 = table3.quest8;
    answer.startTq39 = table3.quest9;
    answer.startTq310 = table3.quest10;
    answer.startTq311 = table3.quest11;
    answer.startTq312 = table3.quest12;
    answer.startTq313 = table3.quest13;
    StartQuestionnaireDTO.Table4DTO table4 = startQuestionnaire.table4;
    answer.startTq41 = table4.quest1;
    answer.startTq42 = table4.quest2;
    answer.startTq43 = table4.quest3;
    answer.startTq44 = table4.quest4;
    answer.startTq45 = table4.quest5;
    answer.startTq46 = table4.quest6;
    answer.startTq47 = table4.quest7;
    LastQuestionnaireDTO.TableDTO table = lastQuestionnaire.table;
    answer.lastTq1 = table.quest1;
    answer.lastTq2 = table.quest2;
    answer.lastTq3 = table.quest3;
    answer.lastTq4 = table.quest4;
    answer.lastTq5 = table.quest5;
    answer.lastTq6 = table.quest6;
    answer.lastTq7 = table.quest7;
    answer.lastTq8 = table.quest8;
    answer.age = lastQuestionnaire.age;
    answer.radio1 = lastQuestionnaire.radio1;
    answer.radio2 = lastQuestionnaire.radio2;
    answer.radio3 = lastQuestionnaire.radio3;
    answer.radio4 = lastQuestionnaire.radio4;
    answer.radio5 = lastQuestionnaire.radio5;
    answer.otherComments = lastQuestionnaire.otherComments;
    //game1
    AfterGameQues1DTO.TableDTO table00 = afterGameQues1.table0;
    AfterGameQues1DTO.TableDTO table01 = afterGameQues1.table1;
    answer.game1Tq01 = table00.quest1;
    answer.game1Tq02 = table00.quest2;
    answer.game1Tq03 = table00.quest3;
    answer.game1Tq11 = table01.quest1;
    answer.game1Tq12 = table01.quest2;
    answer.game1Tq13 = table01.quest3;
    answer.game1Item = afterGameQues1.itemOne;
    //game2
    AfterGameQues1DTO.TableDTO table10 = afterGameQues2.table0;
    AfterGameQues1DTO.TableDTO table11 = afterGameQues2.table1;
    answer.game2Tq01 = table10.quest1;
    answer.game2Tq02 = table10.quest2;
    answer.game2Tq03 = table10.quest3;
    answer.game2Tq11 = table11.quest1;
    answer.game2Tq12 = table11.quest2;
    answer.game2Tq13 = table11.quest3;
    answer.game2Item = afterGameQues2.itemOne;
    //game3
    AfterGameQues1DTO.TableDTO table20 = afterGameQues3.table0;
    AfterGameQues1DTO.TableDTO table21 = afterGameQues3.table1;
    answer.game3Tq01 = table20.quest1;
    answer.game3Tq02 = table20.quest2;
    answer.game3Tq03 = table20.quest3;
    answer.game3Tq11 = table21.quest1;
    answer.game3Tq12 = table21.quest2;
    answer.game3Tq13 = table21.quest3;
    answer.game3Item = afterGameQues3.itemOne;
    //game4
    AfterGameQues1DTO.TableDTO table30 = afterGameQues4.table0;
    AfterGameQues1DTO.TableDTO table31 = afterGameQues4.table1;
    answer.game4Tq01 = table30.quest1;
    answer.game4Tq02 = table30.quest2;
    answer.game4Tq03 = table30.quest3;
    answer.game4Tq11 = table31.quest1;
    answer.game4Tq12 = table31.quest2;
    answer.game4Tq13 = table31.quest3;
    answer.game4Item = afterGameQues4.itemOne;
    return answer;
  }
}
