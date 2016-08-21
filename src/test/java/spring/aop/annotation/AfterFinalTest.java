package spring.aop.annotation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AfterFinalTest {
    @Test
    public void testAfter() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.register(AppConfig.class);
            context.refresh();
            IRemoteService remote = context.getBean("remoteService", IRemoteService.class);
            try {
                remote.close(21);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
