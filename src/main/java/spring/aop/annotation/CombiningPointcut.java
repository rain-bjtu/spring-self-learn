package spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CombiningPointcut {

    @Pointcut(value = "execution(* spring.aop.annotation.IRemoteService+.execute(..))")
    private void executePointcut() {}

    @Pointcut(value = "args(String, int)")
    private void twoParameterPointcut() {}

    @Pointcut(value = "executePointcut() && twoParameterPointcut()")
    public void twoParamExecutePointcut() {}
}
