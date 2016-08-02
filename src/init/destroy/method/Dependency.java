package init.destroy.method;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component("de")
@DependsOn("in")
public class Dependency {
	
	@Autowired
	private Independency in;

	@PostConstruct
	public void init() {
		Util.println(2, "init");
	}
	
	@PreDestroy
	public void destroy() {
		Util.println(2, "destroy");
	}
	
	public Dependency() {
		Util.println(2, "construct");
	}
	
	public void say() {
		System.out.println("--- say ---");
	}

	public Independency getIn() {
		return in;
	}

	public void setIn(Independency in) {
		this.in = in;
	}
}
