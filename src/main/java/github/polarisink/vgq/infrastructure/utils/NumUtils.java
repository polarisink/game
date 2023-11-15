package github.polarisink.vgq.infrastructure.utils;


import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.math.BigDecimal.ROUND_HALF_UP;
import static java.math.BigDecimal.ROUND_UP;

/**
 * apache numberUtils简单封装
 *
 * @author lqs
 * @date 2022/3/28
 */
public class NumUtils {

  private static final int SCALE = 10;
  private static final int SCALE3 = 3;
  private static final int SCALE4 = 4;
  private static final Pattern pattern = Pattern.compile("\\d+");// Pattern.compile("\\D+");//


  /**
   * 四舍五入保留三位
   *
   * @param number
   * @return
   */
  public static Number round2three(Number number) {
    return NumberUtil.round(number.toString(), 3, RoundingMode.HALF_UP);
  }

  public static BigDecimal round2threeB(Number number) {
    return NumberUtil.round(number.toString(), 3, RoundingMode.HALF_UP);
  }

  public static boolean isNumber(String str) {
    return NumberUtil.isNumber(str);
  }

  /**
   * 四舍五入保留三位
   *
   * @param str
   * @return
   */
  public static Number round2three(String str) {
    if (!NumberUtil.isNumber(str)) {
      return null;
    }
    return NumberUtil.round(str, SCALE3, RoundingMode.HALF_UP);
  }

  public static Number round2four(String str) {
    if (!NumberUtil.isNumber(str)) {
      return null;
    }
    return NumberUtil.round(str, SCALE4, RoundingMode.HALF_UP);
  }

  public static Number round2four(Double str) {
    return round2four(str.toString());
  }

  public static Number round2four(Float str) {
    return round2four(str.toString());
  }


  /**
   * 开平方
   *
   * @param b
   * @return
   */
  public static BigDecimal squareRoot(BigDecimal b) {
    return NumUtils.bigRoot(b, 2, SCALE, ROUND_UP);
  }

  public static BigDecimal divide(BigDecimal a, BigDecimal b) {
    return a.divide(b, SCALE, ROUND_HALF_UP);
  }

  /**
   * BigDecimal开n次方根。 转载于: <a href="https://www.xuebuyuan.com/1863340.html">https://www.xuebuyuan.com/1863340.html</a>
   *
   * @param number       被开方数
   * @param n            n次方根
   * @param scale        精度
   * @param roundingMode 舍入规则
   * @return 结果
   */
  public static BigDecimal bigRoot(BigDecimal number, int n, int scale, int roundingMode) {
    boolean negate = false;
    if (n < 0) {
      throw new ArithmeticException();
    }
    if (number.compareTo(BigDecimal.ZERO) < 0) {
      if (n % 2 == 0) {
        throw new ArithmeticException();
      } else {
        number = number.negate();
        negate = true;
      }
    }
    BigDecimal root;
    if (n == 0) {
      root = BigDecimal.ONE;
    } else if (n == 1) {
      root = number;
    } else {
      final BigInteger N = BigInteger.valueOf(n);
      final BigInteger N2 = BigInteger.TEN.pow(n);
      final BigInteger N3 = BigInteger.TEN.pow(n - 1);
      final BigInteger NINE = BigInteger.valueOf(9);
      BigInteger[] C = new BigInteger[n + 1];
      for (int i = 0; i <= n; i++) {
        C[i] = combination(n, i);
      }
      BigInteger integer = number.toBigInteger();
      StringBuilder strInt = Optional.ofNullable(integer.toString()).map(StringBuilder::new).orElse(null);
      int lenInt = strInt.length();
      for (int i = lenInt % n; i < n && i > 0; i++) {
        strInt.insert(0, "0");
      }
      lenInt = (lenInt + n - 1) / n * n;
      BigDecimal fraction = number.subtract(number.setScale(0, BigDecimal.ROUND_DOWN));
      int lenFrac = (fraction.scale() + n - 1) / n * n;
      fraction = fraction.movePointRight(lenFrac);
      StringBuilder strFrac = new StringBuilder(fraction.toPlainString());
      for (int i = strFrac.length(); i < lenFrac; i++) {
        strFrac.insert(0, "0");
      }
      BigInteger res = BigInteger.ZERO;
      BigInteger rem = BigInteger.ZERO;
      for (int i = 0; i < lenInt / n; i++) {
        rem = rem.multiply(N2);
        BigInteger temp = new BigInteger(strInt.substring(i * n, i * n + n));
        rem = rem.add(temp);
        BigInteger j = res.compareTo(BigInteger.ZERO) != 0 ? rem.divide(res.pow(n - 1).multiply(N).multiply(N3)) : NINE;
        BigInteger test = BigInteger.ZERO;
        temp = res.multiply(BigInteger.TEN);
        while (j.compareTo(BigInteger.ZERO) >= 0) {
          test = BigInteger.ZERO;
          if (j.compareTo(BigInteger.ZERO) > 0) {
            for (int k = 1; k <= n; k++) {
              test = test.add(j.pow(k).multiply(C[k]).multiply(temp.pow(n - k)));
            }
          }
          if (test.compareTo(rem) <= 0) {
            break;
          }
          j = j.subtract(BigInteger.ONE);
        }
        rem = rem.subtract(test);
        res = res.multiply(BigInteger.TEN);
        res = res.add(j);
      }
      for (int i = 0; i <= scale; i++) {
        rem = rem.multiply(N2);
        if (i < lenFrac / n) {
          BigInteger temp = new BigInteger(strFrac.substring(i * n, i * n + n));
          rem = rem.add(temp);
        }
        BigInteger j = res.compareTo(BigInteger.ZERO) != 0 ? rem.divide(res.pow(n - 1).multiply(N).multiply(N3)) : NINE;
        BigInteger test = BigInteger.ZERO;
        BigInteger temp = res.multiply(BigInteger.TEN);
        while (j.compareTo(BigInteger.ZERO) >= 0) {
          test = BigInteger.ZERO;
          if (j.compareTo(BigInteger.ZERO) > 0) {
            for (int k = 1; k <= n; k++) {
              test = test.add(j.pow(k).multiply(C[k]).multiply(temp.pow(n - k)));
            }
          }
          if (test.compareTo(rem) <= 0) {
            break;
          }
          j = j.subtract(BigInteger.ONE);
        }
        rem = rem.subtract(test);
        res = res.multiply(BigInteger.TEN);
        res = res.add(j);
      }
      root = new BigDecimal(res).movePointLeft(scale + 1);
      if (negate) {
        root = root.negate();
      }
    }
    return root.setScale(scale, roundingMode);
  }

  public static BigInteger combination(int n, int k) {
    if (k > n || n < 0 || k < 0) {
      return BigInteger.ZERO;
    }
    if (k > n / 2) {
      return combination(n, n - k);
    }
    BigInteger n1 = BigInteger.ONE;
    BigInteger n2 = BigInteger.ONE;
    BigInteger nn = BigInteger.valueOf(n);
    BigInteger kk = BigInteger.valueOf(k);
    for (int i = 0; i < k; i++) {
      n1 = n1.multiply(nn);
      n2 = n2.multiply(kk);
      nn = nn.subtract(BigInteger.ONE);
      kk = kk.subtract(BigInteger.ONE);
    }
    return n1.divide(n2);
  }

  /**
   * 将16进制转换为二进制
   *
   * @param hexStr
   * @return
   */
  public static byte[] hexStr2Byte(String hexStr) {
    if (hexStr.length() < 1) {
      return null;
    }
    byte[] result = new byte[hexStr.length() / 2];
    for (int i = 0; i < hexStr.length() / 2; i++) {
      int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
      int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
      result[i] = (byte) (high * 16 + low);
    }
    return result;
  }

  /**
   * 获取字符串中的数字
   *
   * @param content
   * @return
   */
  public static String getNumbers(String content) {
    // 截取非数字
    Matcher matcher = pattern.matcher(content);
    StringBuilder result = new StringBuilder();
    while (matcher.find()) {
      result.append(matcher.group(0)).append(",");
    }
    // 去掉最后一个逗号
    result = new StringBuilder(result.toString().replaceAll("\\,$", ""));
    return result.toString();
  }

  public static float getFloatValue(String str) {
    float d = 0;
    if (StrUtil.isBlank(str)) {
      return d;
    }
    StringBuilder bf = new StringBuilder();
    char[] chars = str.toCharArray();
    for (char c : chars) {
      if (c >= '0' && c <= '9') {
        bf.append(c);
      } else if (c == '.') {
        if (bf.length() == 0) {
        } else if (bf.indexOf(".") != -1) {
          break;
        } else {
          bf.append(c);
        }
      } else {
        if (bf.length() != 0) {
          break;
        }
      }
    }
    try {
      d = Float.parseFloat(bf.toString());
    } catch (Exception ignored) {
    }
    return d;
  }


}
