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
        SeparatorUtil.printMethodSeparator();
    }

    @After(value = "spring.aop.annotation.MethodSeparatorAspect.methodSeparatorPointcut()")
    public void afterFirst() {
        SeparatorUtil.printMethodSeparator();
    }
}
