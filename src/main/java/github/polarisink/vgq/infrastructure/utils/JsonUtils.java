package github.polarisink.vgq.infrastructure.utils;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;

/**
 * JSON 工具类
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtils {

  private static final ObjectMapper OBJECT_MAPPER = SpringUtils.getBean(ObjectMapper.class);

  public static ObjectMapper getObjectMapper() {
    return OBJECT_MAPPER;
  }

  /**
   * Java对象 转 JSON String
   *
   * @param object Java对象
   * @return JSON String
   */
  public static String toJsonString(Object object) {
    if (ObjectUtil.isNull(object)) {
      return null;
    }
    try {
      return OBJECT_MAPPER.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * JSON String 转 Java对象
   *
   * @param text  JSON String
   * @param clazz Java类
   * @param <T>   泛型
   * @return Java对象
   */
  public static <T> T parseObject(String text, Class<T> clazz) {
    if (StrUtil.isEmpty(text)) {
      return null;
    }
    try {
      return OBJECT_MAPPER.readValue(text, clazz);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 字节数组 转 Java对象
   *
   * @param bytes 字节数组
   * @param clazz Java类
   * @param <T>   泛型
   * @return Java对象
   */
  public static <T> T parseObject(byte[] bytes, Class<T> clazz) {
    if (ArrayUtil.isEmpty(bytes)) {
      return null;
    }
    try {
      return OBJECT_MAPPER.readValue(bytes, clazz);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * JSON String 转 Java泛型对象
   *
   * @param text          JSON String
   * @param typeReference 泛型类信息
   * @param <T>           泛型对象
   * @return 结果
   */
  public static <T> T parseObject(String text, TypeReference<T> typeReference) {
    if (StrUtil.isBlank(text)) {
      return null;
    }
    try {
      return OBJECT_MAPPER.readValue(text, typeReference);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * JSON String 转 字典
   *
   * @param text JSON String
   * @return 字典
   */
  public static Dict parseMap(String text) {
    if (StrUtil.isBlank(text)) {
      return null;
    }
    try {
      return OBJECT_MAPPER.readValue(text, OBJECT_MAPPER.getTypeFactory().constructType(Dict.class));
    } catch (MismatchedInputException e) {
      // 类型不匹配说明不是json
      return null;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * JSON String 转 字典列表
   *
   * @param text JSON String
   * @return 字典列表
   */
  public static List<Dict> parseArrayMap(String text) {
    if (StrUtil.isBlank(text)) {
      return null;
    }
    try {
      return OBJECT_MAPPER.readValue(text, OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, Dict.class));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * JSON String 转 列表
   *
   * @param text JSON String
   * @return 列表
   */
  public static <T> List<T> parseArray(String text, Class<T> clazz) {
    if (StringUtils.isEmpty(text)) {
      return new ArrayList<>();
    }
    try {
      return OBJECT_MAPPER.readValue(text, OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


  /**
   * java对象转map
   *
   * @param object object
   * @return
   */
  public static <T> Map<String, ?> toMap(T object) {
    if (Objects.isNull(object)) {
      return new HashMap<>();
    }
    return OBJECT_MAPPER.convertValue(object, new TypeReference<Map<String, String>>() {
    });
  }
}
