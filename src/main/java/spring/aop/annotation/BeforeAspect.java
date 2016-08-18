package spring.aop.annotation;

import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
@Component
public class BeforeAspect {
    @Pointcut(value = "execution(* spring.aop.annotation.IRemoteService+.login(..)) && args(param, ..)")
    public void beforeLoginAspect(String param) {}

    @Pointcut(value = "execution(* spring.aop.annotation.IRemoteService+.isConnected(..))")
    public void beforeIsConnectedAspect() {}
}
