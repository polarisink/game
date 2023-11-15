package github.polarisink.vgq.infrastructure.asserts;

import cn.hutool.core.util.StrUtil;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * 断言类
 *
 * @Author Administrator
 * @Date 2023/3/27 14:47
 */
public class AssertUtil {

  /**
   * 创建异常
   *
   * @param errorEnum
   * @param args
   * @return
   */
  private static void throwNewException(IResponseEnum errorEnum, Object... args) {
    String msg = args == null || args.length == 0 ? errorEnum.getMessage() : StrUtil.format(errorEnum.getMessage(), args);
    throw new BaseException(errorEnum.getCode(), msg);
  }

  /**
   * 判断对象相关方法================================================================================================
   *
   * @param object
   */
  public static void notNull(Object object, IResponseEnum errorEnum, Object... args) {
    if (object == null) {
      throwNewException(errorEnum, args);
    }
  }

  public static void isNull(Object object, IResponseEnum errorEnum, Object... args) {
    if (object != null) {
      throwNewException(errorEnum, args);
    }
  }


  /**
   * 判断字符串相关方法================================================================================================
   *
   * @param str object
   */

  public static void notEmpty(String str, IResponseEnum errorEnum, Object... args) {
    if (isEmpty(str)) {
      throwNewException(errorEnum, args);
    }
  }

  public static void empty(String str, IResponseEnum errorEnum, Object... args) {
    if (!isEmpty(str)) {
      throwNewException(errorEnum, args);
    }
  }

  public static void notBlank(String str, IResponseEnum errorEnum, Object... args) {
    if (StrUtil.isBlank(str)) {
      throwNewException(errorEnum, args);
    }
  }

  public static void blank(String str, IResponseEnum errorEnum, Object... args) {
    if (StrUtil.isNotBlank(str)) {
      throwNewException(errorEnum, args);
    }
  }

  private static boolean isEmpty(CharSequence str) {
    return str == null || str.length() == 0;
  }

  /**
   * 判断集合相关方法================================================================================================
   *
   * @param collection list
   */
  public static void notEmpty(Collection<?> collection, IResponseEnum errorEnum, Object... args) {
    if (collection == null || collection.isEmpty()) {
      throwNewException(errorEnum, args);
    }
  }

  public static void empty(Collection<?> collection, IResponseEnum errorEnum, Object... args) {
    if (collection != null && !collection.isEmpty()) {
      throwNewException(errorEnum, args);
    }
  }

  /**
   * 判断数组相关方法================================================================================================
   */
  public static void notEmpty(Object[] list, IResponseEnum errorEnum, Object... args) {
    if (list == null || list.length == 0) {
      throwNewException(errorEnum, args);
    }
  }

  public static void empty(Object[] list, IResponseEnum errorEnum, Object... args) {
    if (list != null && list.length > 0) {
      throwNewException(errorEnum, args);
    }
  }

  /**
   * 判断map相关方法================================================================================================
   *
   * @param map map
   */
  public static void notEmpty(Map<?, ?> map, IResponseEnum errorEnum, Object... args) {
    if (map == null || map.isEmpty()) {
      throwNewException(errorEnum, args);
    }
  }

  public static void empty(Map<?, ?> map, IResponseEnum errorEnum, Object... args) {
    if (map != null && !map.isEmpty()) {
      throwNewException(errorEnum, args);
    }
  }

  /**
   * 判断bool表达式相关方法================================================================================================
   *
   * @param expression
   * @param errorEnum
   * @param args
   */
  public static void isFalse(boolean expression, IResponseEnum errorEnum, Object... args) {
    if (expression) {
      throwNewException(errorEnum, args);
    }
  }

  public static void isTrue(boolean expression, IResponseEnum errorEnum, Object... args) {
    if (!expression) {
      throwNewException(errorEnum, args);
    }
  }

  public static <T> void contains(Collection<T> coll, T item, IResponseEnum errorEnum, Object... args) {
    if (!coll.contains(item)) {
      throwNewException(errorEnum, args);
    }
  }

  public static <T> void notContains(Collection<T> coll, T item, IResponseEnum errorEnum, Object... args) {
    if (coll.contains(item)) {
      throwNewException(errorEnum, args);
    }
  }

  public static <T> void equals(Object a, Object b, IResponseEnum errorEnum, Object... args) {
    if (!Objects.equals(a, b)) {
      throwNewException(errorEnum, args);
    }
  }

  public static <T> void notEquals(Object a, Object b, IResponseEnum errorEnum, Object... args) {
    if (Objects.equals(a, b)) {
      throwNewException(errorEnum, args);
    }
  }
}
