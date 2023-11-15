package github.polarisink.vgq.infrastructure.asserts;

import lombok.Getter;

/**
 * 通用业务异常尽可能通用
 *
 * @author aries
 * @date 2022/5/20
 */
@Getter
public enum BusinessE implements IResponseEnum {
  PASSWORD_ERROR("password error!"),
  JACKSON_ERROR("jackson error!")
  ;


  /**
   * 返回码
   */
  private final int code;
  /**
   * 返回消息
   */
  private final String message;

  BusinessE(String errorMsg) {
    this.code = AssertConst.BUSINESS_ERROR_CODE;
    this.message = errorMsg;
  }
}
