package spring.aop;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	private static final String CONFIG_FILE = "spring/aop/application-config.xml";

	public static void main(String[] args) {
		testBeforeAdviceByXML();
	}
	
	public static void testBeforeAdviceByXML() {
		try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				CONFIG_FILE)) {
			ISay say = (ISay) context.getBean("say");
			say.say("Hello", "Judy");
		}
	}
}
