package github.polarisink.vgq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * 游戏问卷服务
 * @author lqsgo
 */
@EnableJpaAuditing
@SpringBootApplication
public class GameApplication {

  public static void main(String[] args) {
    SpringApplication.run(GameApplication.class, args);
  }

}
