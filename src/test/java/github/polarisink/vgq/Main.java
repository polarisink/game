package github.polarisink.vgq;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // 获取所有支持的Locale
        Locale[] availableLocales = Locale.getAvailableLocales();

        System.out.println(availableLocales.length);
        // 打印每个Locale的国家代码
        for (Locale locale : availableLocales) {
            System.out.println(locale.getCountry());
            System.out.println(locale.getDisplayCountry());
            System.out.println(locale.getDisplayName());
            System.out.println(locale.getDisplayCountry(Locale.US));
            System.out.println();
        }
    }
}
