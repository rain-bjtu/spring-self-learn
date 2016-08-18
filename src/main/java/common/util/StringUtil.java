package common.util;

public class StringUtil {

    private StringUtil() {}

    public static String repeatString(String s, int times) {
        if (times < 2) {
            return s;
        }
        int half = times / 2;
        StringBuilder sb = new StringBuilder(repeatString(s, half));
        sb.append(sb);
        if (times % 2 == 0) {
            return sb.toString();
        } else {
            return sb.append(s).toString();
        }
    }
}
