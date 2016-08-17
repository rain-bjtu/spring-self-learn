package spring.aop.before;

public class SayAspect {

    public void beforeAdvice(String words, String who) {
        System.out.println("=== Before advice, param1: " + words + ", param2: " + who);
    }

    public void beforeAdviceWithoutParam() {
        System.out.println("=== Before advice. No parameters.");
    }
}
