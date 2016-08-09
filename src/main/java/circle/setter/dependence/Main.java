package circle.setter.dependence;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static final String CONFIG_FILE = "circle/setter/dependence/application-config.xml";
    public static final String BASE_PACKAGE = "circle.setter.dependence";

    public static void main(String[] args) {
        testByXML();
        System.out.println("==================+++==================");
        testByAnnotation();
    }

    public static void testByXML() {
        try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_FILE)) {
            B b = (B) context.getBean("b");
            b.say();
        }
    }

    public static void testByAnnotation() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan(BASE_PACKAGE);
        // context.register(A.class);
        // context.register(B.class);
        // context.register(C.class);
        context.refresh();
        B b = (B) context.getBean("b");
        b.say();
        if (context instanceof ConfigurableApplicationContext) {
            ((ConfigurableApplicationContext) context).close();
        }
    }
}
