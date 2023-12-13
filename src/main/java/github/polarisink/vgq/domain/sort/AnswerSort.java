package github.polarisink.vgq.domain.sort;

import cn.hutool.core.util.ArrayUtil;
import github.polarisink.vgq.domain.base.BaseJpaEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class AnswerSort extends BaseJpaEntity {
  private Integer first;
  private Integer second;
  private Integer third;
  private Integer fourth;

  public static AnswerSort init() {
    AnswerSort sort = new AnswerSort();
    sort.first = 0;
    sort.second = 0;
    sort.third = 0;
    sort.fourth = 0;
    return sort;
  }

  public void update(int index) {
    switch (index) {
      case 0 -> first++;
      case 1 -> second++;
      case 2 -> third++;
      case 3 -> fourth++;
      default -> throw new IllegalStateException("不合法的索引");
    }
  }

  public int minIndex() {
    int[] array = {first, second, third, fourth};
    int min = ArrayUtil.min(array);
    return ArrayUtil.indexOf(array, min);
  }
}
