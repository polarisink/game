package github.polarisink.vgq.infrastructure.asserts;

import cn.hutool.core.util.StrUtil;
import lombok.Getter;

import java.io.Serializable;

/**
 * <p>基础异常类，所有自定义异常类都需要继承本类</p>
 *
 * @author aries
 * @date 2022/5/2
 */
@Getter
public class BaseException extends RuntimeException implements Serializable {
  protected int code;
  protected String message;

  public BaseException(int code, String msg) {
    super(msg);
    this.code = code;
    this.message = msg;
  }

  public BaseException(IResponseEnum e) {
    this.code = e.getCode();
    this.message = e.getMessage();
  }

  public BaseException(IResponseEnum e, Object... args) {
    this.code = e.getCode();
    this.message = StrUtil.format(e.getMessage(), args);
  }

  public static void thr(IResponseEnum e, Object... args) {
    throw new BaseException(e, args);
  }

  public static void thr(IResponseEnum e) {
    throw new BaseException(e);
  }
}
