package github.polarisink.vgq;

import net.dreamlu.mica.ip2region.core.Ip2regionSearcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Ip2RegionTest {
  @Autowired
  Ip2regionSearcher searcher;
  @Test
  void ipInfo() {
    String baidu = "18.188.219.97";
    String github = "20.205.243.166";
    String hk = "45.204.2.254";
    System.out.println(searcher.memorySearch(baidu));
    System.out.println(searcher.getAddress(baidu));
    System.out.println(searcher.memorySearch(github));
    System.out.println(searcher.getAddress(github));
    System.out.println(searcher.memorySearch(hk));
    System.out.println(searcher.getAddress(hk));
  }
}
