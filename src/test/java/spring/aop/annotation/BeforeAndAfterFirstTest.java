package spring.aop.annotation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeforeAndAfterFirstTest {

    @Test
    public void testBeforeAndAfterAdviceAtFirstOrder() {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.register(AppConfig.class);
            context.refresh();
            IRemoteService remote = context.getBean("remoteService", IRemoteService.class);
            remote.login("you", "pass");
            remote.execute("a");
            // private function will not match the pointcut
            remote.isConnected("you", "pass");
        }
    }

}
