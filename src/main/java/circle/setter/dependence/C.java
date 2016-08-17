package circle.setter.dependence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("c")
public class C {

    @Autowired
    private A a;

    public C() {}

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public void say() {
        System.out.println("----C----");
        a.say();
    }
}
