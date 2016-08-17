package spring.aop.before;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import common.util.SeparatorUtil;

public class Main {
    private static final String CONFIG_FILE = "spring/aop/before/application-config.xml";

    public static void main(String[] args) {
        testBeforeAdviceByXML();
    }

    public static void testBeforeAdviceByXML() {
        try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_FILE)) {
            ISay say = (ISay) context.getBean("say");
            say.say("Hello", "Judy");
            SeparatorUtil.printMethodInnerSeparator();
            say.say();
        }
    }
}
