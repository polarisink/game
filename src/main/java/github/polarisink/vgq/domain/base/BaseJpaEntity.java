package github.polarisink.vgq.domain.base;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * JPA实体类基类，逐步替代以后都要使用改基类
 *
 * @author lqs
 * @date 2022/3/21
 */
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseJpaEntity implements Serializable {

  /**
   * 主键id
   */
  @ExcelProperty(value = "Id",index = 0)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;


  //不指定columnDefinition会默认使用datetime(6)，导致报错
  @ExcelIgnore
  @CreatedDate
  @Column(columnDefinition = "datetime comment '创建时间'")
  protected LocalDateTime createdTime;

  @ExcelIgnore
  @LastModifiedDate
  @Column(columnDefinition = "datetime comment '更新时间'")
  protected LocalDateTime updatedTime;

}
