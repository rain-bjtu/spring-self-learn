package circle.setter.dependence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("b")
public class B {

	@Autowired
	private C c;

	public B() {
	}

	public C getC() {
		return c;
	}

	public void setC(C c) {
		this.c = c;
	}

	public void say() {
		System.out.println("----B----");
		c.say();
	}
}
