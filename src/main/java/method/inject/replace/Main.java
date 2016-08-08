package method.inject.replace;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import common.util.PathUtil;
import common.util.SeparatorUtil;

public class Main {

    private final static String CONFIG_FILE = PathUtil.getApplicationConfigFile(Main.class);

    public static void main(String[] args) {
        testPrinterReplacerByXML();
    }

    public static void testPrinterReplacerByXML() {
        System.out.println(CONFIG_FILE);
        try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_FILE)) {
            SeparatorUtil.printMethodSeparator();
            IPrinter printer = context.getBean("printer", IPrinter.class);
            printer.print("Hello World!", 9);
            SeparatorUtil.printMethodSeparator();
        }
    }

    public static void testPrinterReplacerByAnnotation() {
        // maybe no annotation for replace-method
    }
}
