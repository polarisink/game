package github.polarisink.vgq;

import github.polarisink.vgq.domain.sort.AnswerSort;
import github.polarisink.vgq.domain.sort.AnswerSortRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * 游戏问卷服务
 *
 * @author lqsgo
 */
@EnableJpaAuditing
@SpringBootApplication
@RequiredArgsConstructor
public class GameApplication implements ApplicationRunner {

  private final AnswerSortRepo answerSortRepo;

  public static void main(String[] args) {
    SpringApplication.run(GameApplication.class, args);
  }

  /**
   * 初始化排序字段
   *
   * @param args incoming application arguments
   */
  @Override
  public void run(ApplicationArguments args) {
    long count = answerSortRepo.count();
    if (count == 0) {
      answerSortRepo.save(AnswerSort.init());
    } else if (count > 1) {
      answerSortRepo.deleteAll();
      answerSortRepo.flush();
      answerSortRepo.save(AnswerSort.init());
    }

  }
}
