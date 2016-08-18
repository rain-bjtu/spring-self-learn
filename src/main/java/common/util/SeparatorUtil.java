package common.util;

import static common.util.StringUtil.repeatString;

public class SeparatorUtil {
    private static final String SEPARATOR = "-";
    private static final int TIMES = 101;
    private static final String INNER_SEPARATOR = "-    ";
    private static final int INNER_TIMES = 20;

    private SeparatorUtil() {}

    public static void printMethodSeparator() {
        System.out.println(repeatString(SEPARATOR, TIMES));
    }

    public static void printMethodInnerSeparator() {
        System.out.println(repeatString(INNER_SEPARATOR, INNER_TIMES) + SEPARATOR);
    }

    public static void printMethodSeparator(String param) {
        int length = TIMES;
        if (param.length() >= length) {
            length = param.length() + 10;
        }
        int before = (length - param.length()) / 2;
        int after = length - before - param.length();
        System.out.println(repeatString(SEPARATOR, before) + param + StringUtil.repeatString(SEPARATOR, after));
    }
}
