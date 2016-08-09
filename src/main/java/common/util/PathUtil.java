package common.util;

public class PathUtil {

    private PathUtil() {
    }

    public static String getApplicationConfigFile(Class<?> c) {
        return c.getPackage().getName().replace(".", "/") + "/application-config.xml";
    }
}
