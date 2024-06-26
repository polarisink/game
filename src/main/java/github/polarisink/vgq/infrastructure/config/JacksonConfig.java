package github.polarisink.vgq.infrastructure.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import github.polarisink.vgq.infrastructure.utils.JacksonUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * jackson配置
 *
 * @author aries
 * @date 2022/8/17
 */
@Configuration
public class JacksonConfig {

  /**
   * redis用的,需要把类型名也存储进去
   *
   * @return
   */
  @Bean("redis")
  public ObjectMapper redis() {
    ObjectMapper objectMapper = new ObjectMapper();
    //set for localDateTime
    objectMapper.disable(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS);
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);
    //必须设置，否则无法将JSON转化为对象，会转化成Map类型
    // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
    //objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
    return objectMapper;
  }


  /**
   * 默认实现,与JacksonUtil中保持一致
   *
   * @return
   */
  @Bean
  @Primary
  public ObjectMapper objectMapper() {
    return JacksonUtil.getObjectMapper();
  }

}
