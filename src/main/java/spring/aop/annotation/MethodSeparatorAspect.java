package spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class MethodSeparatorAspect {

    @Pointcut(value = "execution(* spring.aop.annotation.IRemoteService+.*(..))")
    public void methodSeparatorPointcut() {}
}
