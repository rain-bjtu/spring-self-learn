package spring.aop.annotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import common.util.SeparatorUtil;

@Component("adviceOrder1")
@Aspect
@Order(1)
public class AdviceOrder1 {

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
}
