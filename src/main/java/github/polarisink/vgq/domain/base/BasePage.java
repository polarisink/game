package github.polarisink.vgq.domain.base;

import lombok.Data;

/**
 * 分页查询请求类基类
 *
 * @author aries
 * @date 2022/6/21
 */
@Data
public class BasePage {
  int page = 1;
  int size = 10;
  protected Boolean sort = false;
  //private String sortField;
}
