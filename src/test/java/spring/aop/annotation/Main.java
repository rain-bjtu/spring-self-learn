package spring.aop.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        testBeforeAndAfterAdviceAtFirstOrder();
    }

    public static void testBeforeAndAfterAdviceAtFirstOrder() {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.register(AppConfig.class);
            context.refresh();
            IRemoteService remote = context.getBean("remoteService", IRemoteService.class);
            remote.login("you", "pass");
        }
    }
}
