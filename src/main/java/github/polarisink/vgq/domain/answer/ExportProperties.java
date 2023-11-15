package github.polarisink.vgq.domain.answer;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author lqsgo
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "export")
public class ExportProperties {
  private String password;
  private String sheet;
  private String frequentMsg;

}
