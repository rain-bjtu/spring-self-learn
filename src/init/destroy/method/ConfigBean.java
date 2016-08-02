package init.destroy.method;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class ConfigBean {

	@Bean(name="in", initMethod="init", destroyMethod="destroy")
	public Independency in() {
		return new Independency();
	}
	
	@Bean(name="de", initMethod="init", destroyMethod="destroy")
	@DependsOn("in")
	public Dependency de() {
		return new Dependency();
	}
}
