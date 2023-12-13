package github.polarisink.vgq.domain.sort;

import github.polarisink.vgq.domain.base.BaseJpaRepo;
import org.springframework.data.jpa.repository.Query;

public interface AnswerSortRepo extends BaseJpaRepo<AnswerSort> {
  @Query(value = "select * from answer_sort limit 1",nativeQuery = true)
  AnswerSort findFirst();
}
