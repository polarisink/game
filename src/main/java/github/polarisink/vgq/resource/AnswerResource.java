package github.polarisink.vgq.resource;

import github.polarisink.vgq.application.AnswerService;
import github.polarisink.vgq.domain.answer.AnswerSubmitReq;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

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
   * 提交
   *
   * @param req
   */
  @PostMapping("/submit")
  public void submit(@RequestBody @Validated AnswerSubmitReq req) {
    service.submit(req);
  }

  /**
   * 导出
   *
   * @param password 密码
   * @param response
   */
  @GetMapping("/export/{password}")
  public void export(@PathVariable String password, HttpServletResponse response) {
    service.export(password, response);
  }
}
