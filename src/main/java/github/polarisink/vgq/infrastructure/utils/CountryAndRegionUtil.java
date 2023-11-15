package github.polarisink.vgq.infrastructure.utils;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 国家地区中英文名工具类
 *
 * @author lqsgo
 */
public class CountryAndRegionUtil {
  private static final Map<String, String> cnEnMap = new HashMap<>();
  private static final Map<String, String> cnCodeMap = new HashMap<>();

  static {
    for (Locale locale : Locale.getAvailableLocales()) {
      cnEnMap.put(locale.getDisplayCountry(), locale.getDisplayCountry(Locale.US));
      cnCodeMap.put(locale.getDisplayCountry(), locale.getCountry());
    }
  }

  public static String getEnByCn(String country) {
    return cnEnMap.getOrDefault(country, Locale.US.getDisplayCountry(Locale.US));
  }

  public static String getCodeByCn(String country) {
    return cnCodeMap.getOrDefault(country, Locale.US.getCountry());
  }

}
