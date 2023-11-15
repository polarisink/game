package github.polarisink.vgq.infrastructure.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * stream工具类集合
 *
 * @author aries
 * @date 2022/11/25
 */
public class StreamUtils {

  /**
   * 按照指定规则去重
   *
   * @param keyExtractor
   * @param <T>
   * @return
   */
  public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
    Map<Object, Boolean> seen = new ConcurrentHashMap<>();
    //putIfAbsent方法添加键值对，如果map集合中没有该key对应的值，则直接添加，并返回null，如果已经存在对应的值，则依旧为原来的值。
    //如果返回null表示添加数据成功(不重复)，不重复(null==null :TRUE)
    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
  }

}
