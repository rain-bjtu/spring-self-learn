package init.destroy.method;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static final String CONFIG_FILE = "init/destroy/method/application-config.xml";
	public static final String BASE_PACKAGE = "init.destroy.method";

	public static void main(String[] args) {
		testByXML();
//		System.out.println("==================+++==================");
//		testByAnnotation();
//		testByConfig();
	}

	public static void testByXML() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				CONFIG_FILE);
		// if not call registerShutdownHook(), destroy method will not be called.
		// but init method will always be called.
		context.registerShutdownHook();
		Dependency de = (Dependency) context.getBean("de");
		de.say();
		if (context instanceof ConfigurableApplicationContext) {
			((ConfigurableApplicationContext) context).close();
		}
	}

	public static void testByAnnotation() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan(BASE_PACKAGE);
		context.refresh();
		// if not call registerShutdownHook(), destroy method will not be called.
		// but init method will always be called.
		// registerShutdownHook() can be called before or after refresh()
		context.registerShutdownHook();
		Dependency de = (Dependency) context.getBean("de");
		de.say();
		if (context instanceof ConfigurableApplicationContext) {
			((ConfigurableApplicationContext) context).close();
		}
	}
	
	public static void testByConfig() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ConfigBean.class);
		context.refresh();
		// if not call registerShutdownHook(), destroy method will not be called.
		// but init method will always be called.
		// registerShutdownHook() can be called before or after refresh()
		context.registerShutdownHook();
		Dependency de = (Dependency) context.getBean("de");
		de.say();
		if (context instanceof ConfigurableApplicationContext) {
			((ConfigurableApplicationContext) context).close();
		}
	}
}
