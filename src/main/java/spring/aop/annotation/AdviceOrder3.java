package spring.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import common.util.SeparatorUtil;

@Component
@Aspect
@Order(3)
public class AdviceOrder3 {

    @Before(value = "spring.aop.annotation.MethodPointcut.loginPointcut(p)")
    public void beforeLoginPrintUsername(String p) {
        SeparatorUtil.printMethodSeparator("Before Order 3");
        System.out.println("Username is: " + p);
    }

    @Before(value = "spring.aop.annotation.MethodPointcut.isConnectedPointcut() && args(p, ..)")
    public void beforeIsConnectedPrintUsername(String p) {
        SeparatorUtil.printMethodSeparator("Before Order 3");
        System.out.println("Username is: " + p);
    }

    @AfterReturning(value = "spring.aop.annotation.MethodPointcut.isConnectedPointcut()", returning = "retVal")
    public void afterReturnIsConnectedPrintConnectionStatus(Object retVal) {
        System.out.println("Is connected? --- " + retVal);
        retVal = true;
        System.out.println("Is connected? --- " + retVal);
    }

    @AfterThrowing(value = "spring.aop.annotation.MethodPointcut.closePointcut()", throwing = "ex")
    public void afterThrowClosePrintException(Exception ex) {
        System.out.println(ex);
    }

    @After(value = "spring.aop.annotation.MethodPointcut.closePointcut()")
    public void afterCloseFinalPrint() {
        System.out.println("After Final!");
    }

    @Around(value = "spring.aop.annotation.MethodPointcut.errorOccurPointcut()")
    public Object aroundErrorOccur(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("before...");
        String result = (String) pjp.proceed();
        return result + "...";
    }

    /**
     * can not access this private pointcut
     */
//    @After(value = "spring.aop.annotation.CombiningPointcut.executePointcut()")
//    public void afterAllExecute() {
//        System.out.println("Use private pointcut match all execute method!");
//    }

    @After(value = "spring.aop.annotation.CombiningPointcut.twoParamExecutePointcut() && args(p1, p2)")
    public void afterExecuteWith2Param(String p1, int p2) {
        System.out.println("Use Combining pointcut match  execute method with 2 parameters!");
        System.out.format("cmd: {%s}, times: {%d}\n", p1, p2);
    }
}
