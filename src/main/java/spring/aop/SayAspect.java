package spring.aop;

public class SayAspect {

    public void beforeAdvice(String param1, String param2) {
        System.out.println("=== Before advice, param1: " + param1 + ", param2: " + param2);
    }
}
