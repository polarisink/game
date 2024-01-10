package github.polarisink.vgq.domain.answer;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@NoArgsConstructor
@Data
public class AnswerSubmitReq {
  private int index;
  private LocalDateTime startTime;
  private LocalDateTime endTime;
  private StartQuestionnaireDTO startQuestionnaire;
  private List<AfterGameQues1DTO> afterGameQues;
  private LastQuestionnaireDTO lastQuestionnaire;

  @NoArgsConstructor
  @Data
  public static class StartQuestionnaireDTO {
    private Table0 table0;
    private Table1 table1;
    private Table2 table2;

    @NoArgsConstructor
    @Data
    public static class Table0 {
      private String quest1;
      private String quest2;
      private String quest3;
      private String quest4;
      private String quest5;
    }

    @NoArgsConstructor
    @Data
    public static class Table1 {
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
    }

    @NoArgsConstructor
    @Data
    public static class Table2 {
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

  }

  @Data
  public static class AfterGameQues1DTO {
    private Integer gameCode;
    private Table table0;
    private Table table1;
    private Table table2;
    private Table table3;

    @Data
    public static class Table {

      private String quest1;

      private String quest2;

      private String quest3;
    }

  }


  @Data
  public static class LastQuestionnaireDTO {
    private TableDTO table;
    private Integer age;
    private String radio1;
    private String radio2;
    private String radio3;
    private String radio4;
    private String radio5;
    private String otherComments;

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

  public Answer convert(String ip, String region) {
    Answer answer = new Answer();
    answer.classify = index;
    answer.ip = ip;
    answer.region = region;
    answer.startTime = startTime;
    answer.endTime = endTime;
    //具体数据
    StartQuestionnaireDTO.Table0 table0 = startQuestionnaire.table0;
    answer.startTq01 = table0.quest1;
    answer.startTq02 = table0.quest2;
    answer.startTq03 = table0.quest3;
    answer.startTq04 = table0.quest4;
    answer.startTq05 = table0.quest5;
    StartQuestionnaireDTO.Table1 table1 = startQuestionnaire.table1;
    answer.startTq11 = table1.quest1;
    answer.startTq12 = table1.quest2;
    answer.startTq13 = table1.quest3;
    answer.startTq14 = table1.quest4;
    answer.startTq15 = table1.quest5;
    answer.startTq16 = table1.quest6;
    answer.startTq17 = table1.quest7;
    answer.startTq18 = table1.quest8;
    answer.startTq19 = table1.quest9;
    answer.startTq110 = table1.quest10;
    answer.startTq111 = table1.quest11;
    answer.startTq112 = table1.quest12;
    StartQuestionnaireDTO.Table2 table2 = startQuestionnaire.table2;
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
    answer.startTq212 = table2.quest12;
    answer.startTq213 = table2.quest13;
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
    afterGameQues.sort(Comparator.comparing(AfterGameQues1DTO::getGameCode));
    AfterGameQues1DTO quesDTO;
    int i;
    AfterGameQues1DTO.Table table00;

    i = 0;
    quesDTO = afterGameQues.get(i);
    table00 = quesDTO.table0;
    answer.game1Tq01 = table00.quest1;
    table00 = quesDTO.table1;
    answer.game1Tq11 = table00.quest1;
    answer.game1Tq12 = table00.quest2;
    answer.game1Tq13 = table00.quest3;
    table00 = quesDTO.table2;
    answer.game1Tq21 = table00.quest1;
    answer.game1Tq22 = table00.quest2;
    answer.game1Tq23 = table00.quest3;
    table00 = quesDTO.table3;
    answer.game1Tq31 = table00.quest1;
    answer.game1Tq32 = table00.quest2;
    answer.game1Tq33 = table00.quest3;
    answer.game1Code = index * 4 + i + 1;
    //game2
    i = 1;
    quesDTO = afterGameQues.get(i);
    table00 = quesDTO.table0;
    answer.game2Tq01 = table00.quest1;
    table00 = quesDTO.table1;
    answer.game2Tq11 = table00.quest1;
    answer.game2Tq12 = table00.quest2;
    answer.game2Tq13 = table00.quest3;
    table00 = quesDTO.table2;
    answer.game2Tq21 = table00.quest1;
    answer.game2Tq22 = table00.quest2;
    answer.game2Tq23 = table00.quest3;
    table00 = quesDTO.table3;
    answer.game2Tq31 = table00.quest1;
    answer.game2Tq32 = table00.quest2;
    answer.game2Tq33 = table00.quest3;
    answer.game2Code = index * 4 + i + 1;
    //game3
    i = 2;
    quesDTO = afterGameQues.get(i);
    table00 = quesDTO.table0;
    answer.game3Tq01 = table00.quest1;
    table00 = quesDTO.table1;
    answer.game3Tq11 = table00.quest1;
    answer.game3Tq12 = table00.quest2;
    answer.game3Tq13 = table00.quest3;
    table00 = quesDTO.table2;
    answer.game3Tq21 = table00.quest1;
    answer.game3Tq22 = table00.quest2;
    answer.game3Tq23 = table00.quest3;
    table00 = quesDTO.table3;
    answer.game3Tq31 = table00.quest1;
    answer.game3Tq32 = table00.quest2;
    answer.game3Tq33 = table00.quest3;
    answer.game3Code = index * 4 + i + 1;
    //game4
    i = 3;
    quesDTO = afterGameQues.get(i);
    table00 = quesDTO.table0;
    answer.game4Tq01 = table00.quest1;
    table00 = quesDTO.table1;
    answer.game4Tq11 = table00.quest1;
    answer.game4Tq12 = table00.quest2;
    answer.game4Tq13 = table00.quest3;
    table00 = quesDTO.table2;
    answer.game4Tq21 = table00.quest1;
    answer.game4Tq22 = table00.quest2;
    answer.game4Tq23 = table00.quest3;
    table00 = quesDTO.table3;
    answer.game4Tq31 = table00.quest1;
    answer.game4Tq32 = table00.quest2;
    answer.game4Tq33 = table00.quest3;
    answer.game4Code = index * 4 + i + 1;
    return answer;
  }
}
