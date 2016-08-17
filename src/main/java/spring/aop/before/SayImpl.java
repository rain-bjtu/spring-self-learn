package spring.aop.before;

public class SayImpl implements ISay {

    @Override
    public void say(String words, String who) {
        System.out.println("I am saying: " + words + ", and I am " + who + "!");
    }

    @Override
    public void say() {
        System.out.println("Nothing to say");
    }

}
