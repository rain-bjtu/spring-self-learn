package spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodPointcut {

    @Pointcut(value = "execution(* spring.aop.annotation.IRemoteService+.login(..)) && args(param, ..)")
    public void loginPointcut(String param) {}

    @Pointcut(value = "execution(* spring.aop.annotation.IRemoteService+.isConnected(..))")
    public void isConnectedPointcut() {}

    @Pointcut(value = "execution(* spring.aop.annotation.IRemoteService+.close(..))")
    public void closePointcut() {}

    @Pointcut(value = "execution(* spring.aop.annotation.IRemoteService+.errorOccur(..))")
    public void errorOccurPointcut() {}
    
    // this pointcut will not take effect, because it want to cut across a private method
    @Pointcut(value = "execution(private * spring.aop.annotation.IRemoteService+.*(..))")
    public void privatePointcut() {}
}
