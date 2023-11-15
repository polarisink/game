package github.polarisink.vgq.infrastructure.aspects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author lqs http请求日志打印
 * @date 2021/11/6
 */
@Slf4j
@Aspect
@Component
public class WebLogAspect {

  private static final ObjectMapper mapper = new ObjectMapper();

  /**
   * 以resource包下定义的所有请求为切入点
   */
  @Pointcut(value = "@annotation(org.springframework.web.bind.annotation.RequestMapping)||" +
      "@annotation(org.springframework.web.bind.annotation.PostMapping)||" +
      "@annotation(org.springframework.web.bind.annotation.GetMapping)")
  public void webLog() {
  }


  /**
   * 环绕
   *
   * @param point
   * @return
   * @throws Throwable
   */
  @Around("webLog()")
  public Object doAround(ProceedingJoinPoint point) throws Throwable {
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
    //执行逻辑，计算执行时间
    long start = System.currentTimeMillis();
    Object result = point.proceed();
    long stop = System.currentTimeMillis();
    //打印简单日志
    StringBuffer requestURL = request.getRequestURL();
    String method = request.getMethod();
    String declaringTypeName = point.getSignature().getDeclaringTypeName();
    String name = point.getSignature().getName();
    String remoteAddr = request.getRemoteAddr();
    long consume = stop - start;
    //TODO 怎么合理的打印不同信息
    String argsStr = "";
    try {
      String s = mapper.writeValueAsString(point.getArgs());
      if (s.length() <= 1000) {
        argsStr = s;
      }
    } catch (JsonProcessingException ignored) {
    }
    LOG.info("\n*********************** Start ***********************\n" +
            "* Request URL    : {}\n" +
            "* HTTP Method    : {}\n" +
            "* Class Method   : {}.{}\n" +
            "* IP Address     : {}\n" +
            "* Request Args   : {}\n" +
            "* Time-Consuming : {}ms\n" +
            "* *********************** End ***********************\n",
        requestURL, method, declaringTypeName, name, remoteAddr, argsStr, consume);

    return result;
  }


    /*@Getter
    @Setter
    public static class WebLog {
        private String url;
        private String httpMethod;
        private String classMethod;
        private String ip;
        private String requestArgs;
        private String responseArgs;
        private Long timeConsume;

        @Override
        public String toString() {
            return String.format(
                    "\n*********************** Start ***********************\n" +
                            "* Request URL    : %s\n" +
                            "* HTTP Method    : %s\n" +
                            "* Class Method   : %s\n" +
                            "* IP Address     : %s\n" +
                            "* Request Args   : %s\n" +
                            "* Time-Consuming : %dms\n" +
                            "* Response Args  : %s\n" +
                            "* *********************** End ***********************\n", url, httpMethod, classMethod, ip, requestArgs, timeConsume, responseArgs);
        }
    }*/
}
