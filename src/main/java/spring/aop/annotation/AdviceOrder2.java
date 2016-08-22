package spring.aop.annotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import common.util.SeparatorUtil;

@Aspect
@Order(2)
@Component
public class AdviceOrder2 {

    // @Before(value = "MethodSeparatorAspect.methodSeparatorPointcut()")
    @Before(value = "spring.aop.annotation.MethodSeparatorAspect.methodSeparatorPointcut()")
    public void beforeFirst() {
        SeparatorUtil.printMethodSeparator("=", "Before Order 2");
    }

    // this is a private advice, but it still function
    @After(value = "spring.aop.annotation.MethodSeparatorAspect.methodSeparatorPointcut()")
    private void afterFirst() {
        SeparatorUtil.printMethodSeparator("=", "After Order 2");
    }
}
