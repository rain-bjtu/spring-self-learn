package property.placeholder.value;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static String APP_CONFIG = "property/placeholder/value/application-config.xml";

    public static void main(String[] args) {

        testPopularByAnnotation();
        testBlankByAnnotation();
        testBlankByXML();
    }

    public static void testPopularByAnnotation() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(PopularDisc.class);
        context.refresh();
        CompactDisc disc = context.getBean("popular", CompactDisc.class);
        disc.play();
        context.close();
    }

    public static void testBlankByAnnotation() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ExpressiveConfig.class);
        context.refresh();
        CompactDisc disc = context.getBean(CompactDisc.class);
        disc.play();
        context.close();
    }

    public static void testBlankByXML() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(APP_CONFIG);
        CompactDisc disc = context.getBean(CompactDisc.class);
        disc.play();
        context.close();
    }
}
