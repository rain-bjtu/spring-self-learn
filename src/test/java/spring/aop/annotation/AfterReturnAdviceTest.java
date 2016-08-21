package spring.aop.annotation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AfterReturnAdviceTest {

    /**
     * Test After Returning could not change the return value, just could read it
     */
    @Test
    public void testAfterReturn() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.register(AppConfig.class);
            context.refresh();
            IRemoteService remote = context.getBean("remoteService", IRemoteService.class);
            // private function will not match the pointcut
            boolean result = remote.isConnected("you", "pass");
            System.out.println("At the last, the connection status is: " + result);
        }
    }
}
