package spring.aop.annotation;

public class WhoImpl implements IWho {

    @Override
    public void whoAmI() {
        System.out.println("-------------- I am computer!");
    }

}
