package github.polarisink.vgq.resource;

import github.polarisink.vgq.application.AnswerService;
import github.polarisink.vgq.domain.answer.AnswerSubmitReq;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 问卷
 *
 * @author lqsgo
 */
@RestController
@RequestMapping("/answer")
public class AnswerResource {
  private final AnswerService service;

  public AnswerResource(AnswerService service) {
    this.service = service;
  }

  /**
   * ping
   *
   * @return pong
   */
  @GetMapping("/ping")
  public String ping() {
    return "pong";
  }

  /**
   * 提交
   *
   * @param req 提交请求
   */
  @PostMapping("/submit")
  public void submit(@RequestBody @Validated AnswerSubmitReq req) {
    service.submit(req);
  }

  /**
   * 导出
   *
   * @param index    分组
   * @param password 密码
   * @param response 响应
   */
  @GetMapping({"/export/{password}/{index}","/export/{password}"})
  public void export(@PathVariable String password, @PathVariable(required = false) Integer index, HttpServletResponse response) throws IOException {
    service.export(index, password, response);
  }

  /**
   * 获取index
   *
   * @return index
   */
  @GetMapping("/index")
  public int index() {
    return service.index();
  }
}
