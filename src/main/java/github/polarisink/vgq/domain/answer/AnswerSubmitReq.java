package github.polarisink.vgq.domain.answer;

import lombok.Data;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * @author lqsgo
 */
@Data
public class AnswerSubmitReq {
  /**
   * 用户名
   */
  private String userName;
  /**
   * 开始时间
   */
  private LocalDateTime startTime;
  /**
   * 第一个提交的
   */
  private FirstSubmitItem start;
  /**
   * 第二个提交的
   */
  private SecondSubmitItem first;
  /**
   * 第三个提交的
   */
  private SecondSubmitItem second;
  /**
   * 最后一个
   */
  private LastSubmitItem last;

  @Data
  public static class FirstSubmitItem {
    @Size(max = 130, message = "年龄必须为正整数且不能超过130岁！")
    private Integer age;
    private String checkRadio;
    private Integer quest1;
    private Integer quest2;
    private Integer quest3;
    private Integer quest4;
    private Integer quest5;
  }

  @Data
  public static class SecondSubmitItem {
    private Integer itemOne;
    private Integer quest1;
    private Integer quest2;
    private Integer quest3;
  }

  @Data
  public static class LastSubmitItem {
    private Integer quest1;
    private Integer quest2;
    private Integer quest3;
    private String otherComments;
  }
}
