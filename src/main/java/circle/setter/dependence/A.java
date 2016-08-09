package circle.setter.dependence;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component(value = "a")
public class A {

    @Resource(name = "b")
    private B b;

    public A() {
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public void say() {
        System.out.println("----A----");
    }
}
