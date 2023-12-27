package github.polarisink.vgq.domain.answer;

import github.polarisink.vgq.domain.base.BaseJpaRepo;

import java.util.List;

public interface AnswerRepo extends BaseJpaRepo<Answer> {
  List<Answer> findByClassify(Integer index);
}
