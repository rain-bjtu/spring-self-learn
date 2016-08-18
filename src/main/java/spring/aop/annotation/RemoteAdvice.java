package spring.aop.annotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import common.util.SeparatorUtil;

@Component("remoteAdvice")
@Aspect
public class RemoteAdvice {

    // @Before(value = "MethodSeparatorAspect.methodSeparatorPointcut()")
    @Before(value = "spring.aop.annotation.MethodSeparatorAspect.methodSeparatorPointcut()")
    public void beforeFirst() {
        SeparatorUtil.printMethodSeparator("Before Order 1");
    }

    @After(value = "spring.aop.annotation.MethodSeparatorAspect.methodSeparatorPointcut()")
    public void afterFirst() {
        SeparatorUtil.printMethodSeparator("After Order 1");
        System.out.println();
    }

    @Before(value = "spring.aop.annotation.BeforeAspect.beforeLoginAspect(p)")
    public void beforeLoginPrintUsername(String p) {
        SeparatorUtil.printMethodSeparator("Before Order 2");
        System.out.println("Username is: " + p);
    }

    @Before(value = "spring.aop.annotation.BeforeAspect.beforeIsConnectedAspect() && args(p, ..)")
    public void beforeIsConnectedPrintUsername(String p) {
        SeparatorUtil.printMethodSeparator("Before Order 2");
        System.out.println("Username is: " + p);
    }
}
