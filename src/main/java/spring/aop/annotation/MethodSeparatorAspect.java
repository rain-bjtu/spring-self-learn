package spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodSeparatorAspect {

    @Pointcut(value = "execution(* spring.aop.annotation.IRemoteService+.*(..))")
    public void methodSeparatorPointcut() {}
}
