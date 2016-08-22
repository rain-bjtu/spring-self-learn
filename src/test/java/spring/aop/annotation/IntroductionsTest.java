package spring.aop.annotation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IntroductionsTest {

    @Test
    public void testIntroduction() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.register(AppConfig.class);
            context.refresh();
            IWho remote = context.getBean("remoteService", IWho.class);
            remote.whoAmI();
        }
    }
}
