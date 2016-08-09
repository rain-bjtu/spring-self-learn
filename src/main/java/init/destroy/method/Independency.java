package init.destroy.method;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component("in")
public class Independency {

    @PostConstruct
    public void init() {
        Util.println(1, "init");
    }

    @PreDestroy
    public void destroy() {
        Util.println(1, "destroy");
    }

    public Independency() {
        Util.println(1, "construct");
    }
}
