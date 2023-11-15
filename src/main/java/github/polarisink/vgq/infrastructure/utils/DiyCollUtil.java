package github.polarisink.vgq.infrastructure.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

/**
 * @author aries
 * @date 2022/5/27
 */
public class DiyCollUtil {

  private static final String COMMA = ",";

  /**
   * list转字符串逗号[,]分隔
   *
   * @param list
   * @return
   */
  public static String list2String(List<Long> list) {
    return CollUtil.isNotEmpty(list) ? CollUtil.join(list, COMMA) : COMMA;
  }

  /**
   * 逗号分隔的字符串转list
   *
   * @param str
   * @return
   */
  public static List<Long> string2list(String str) {
    if (StrUtil.isBlank(str)) {
      return Collections.emptyList();
    }
    return Arrays.stream(str.split(COMMA)).map(s -> Long.valueOf(s.trim())).collect(toList());
  }

  /**
   * 获取重复元素
   *
   * @param stream
   * @param <T>
   * @return
   */
  public static <T> List<T> getDuplicateElements(List<T> stream) {
    return stream.stream()
        // 获得元素出现频率的 Map，键为元素，值为元素出现的次数
        .collect(toMap(e -> e, e -> 1, Integer::sum))
        // Set<Entry>转换为Stream<Entry>
        .entrySet().stream()
        // 过滤出元素出现次数大于 1 的 entry
        .filter(entry -> entry.getValue() > 1)
        // 获得 entry 的键（重复元素）对应的 Stream
        .map(Map.Entry::getKey).collect(toList());
  }

  /**
   * 矩阵转置
   *
   * @param table
   * @param <T>
   * @return
   */
  public static <T> List<List<T>> transpose(List<List<T>> table) {
    List<List<T>> ret = new ArrayList<>();
    final int N = table.get(0).size();
    for (int i = 0; i < N; i++) {
      List<T> col = new ArrayList<>();
      for (List<T> row : table) {
        col.add(row.get(i));
      }
      ret.add(col);
    }
    return ret;
  }

  /**
   * 判断两个集合的值是否相等
   *
   * @param coll
   * @param coll2
   * @param <T>
   * @return
   */
  public static <T> boolean valueEquals(Collection<T> coll, Collection<T> coll2) {
    if (Objects.equals(coll, coll2)) {
      return true;
    }
    HashSet<T> ts = new HashSet<>(coll);
    boolean containsSameElements = true;
    for (T element : new HashSet<>(coll2)) {
      if (!ts.contains(element)) {
        containsSameElements = false;
        break;
      }
    }
    HashSet<T> ts2 = new HashSet<>(coll2);
    boolean containsSameElements2 = true;
    for (T element : new HashSet<>(coll)) {
      if (!ts2.contains(element)) {
        containsSameElements2 = false;
        break;
      }
    }
    return containsSameElements && containsSameElements2;
  }

  public static boolean isAllBlankStr(List<String> list) {
    for (String t : list) {
      if (StrUtil.isNotBlank(t)) {
        return false;
      }
    }
    return true;
  }

  public static <T, E> Stream<E> stream(Collection<T> coll, Function<? super T, E> mapper) {
    return coll.stream().map(mapper);
  }

  /**
   * 简单的stream类型转换器
   *
   * @param coll   原集合
   * @param mapper 类型转换方法
   * @param <T>    集合类型
   * @param <E>    返回集合类型
   * @return 返回集合
   */
  public static <T, E> List<E> mapToList(Collection<T> coll, Function<? super T, E> mapper) {
    return stream(coll, mapper).toList();
  }

  public static <T, E> Set<E> mapToSet(Collection<T> coll, Function<? super T, E> mapper) {
    return stream(coll, mapper).collect(Collectors.toSet());
  }

}
