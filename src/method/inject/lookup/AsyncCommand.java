package method.inject.lookup;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AsyncCommand implements Command {

    @Override
    public Object execute() {
        return this;
    }

}
