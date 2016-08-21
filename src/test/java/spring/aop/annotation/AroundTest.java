package spring.aop.annotation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundTest {
    @Test
    public void testAround() throws Exception {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.register(AppConfig.class);
            context.refresh();
            IRemoteService remote = context.getBean("remoteService", IRemoteService.class);
            String result = remote.errorOccur(6);
            System.out.println(result);
        }
    }
}
