package method.inject.lookup;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static final String XML_CONFIG = Main.class.getPackage().getName().replace(".", "/")
            + "/application-config.xml";

    public static void main(String[] args) {
        testCommandManagerWithContextByXML();
        testCommandManagerByXML();
        testCommandManagerByAnnotation();
    }

    public static void testCommandManagerWithContextByXML() {
        try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(XML_CONFIG)) {
            CommandManagerWithContext manager = (CommandManagerWithContext) context
                    .getBean("commandManagerWithContext");
            printSeparator();
            System.out.println("First Construct: " + manager.process());
            System.out.println("Second Construct: " + manager.process());
            printSeparator();
        }
    }

    public static void testCommandManagerByXML() {
        try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(XML_CONFIG)) {
            CommandManager manager = (CommandManager) context.getBean("commandManager");
            printSeparator();
            System.out.println("First Construct: " + manager.process());
            System.out.println("Second Construct: " + manager.process());
            printSeparator();
        }
    }

    public static void testCommandManagerByAnnotation() {
        try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(CommandManager.class,
                AsyncCommand.class)) {
            CommandManager manager = (CommandManager) context.getBean("commandManager");
            printSeparator();
            System.out.println("First Construct: " + manager.process());
            System.out.println("Second Construct: " + manager.process());
            printSeparator();
        }
    }

    private static void printSeparator() {
        System.out.println("-------------------------------------------");
    }
}
