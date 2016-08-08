package method.inject.lookup;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class CommandManagerWithContext implements ApplicationContextAware {

    private ApplicationContext context;

    public Object process() {
        Command command = createCommand();
        return command.execute();
    }

    public Command createCommand() {
        return (Command) this.context.getBean("asyncCommand");
    }

    @Override
    public void setApplicationContext(ApplicationContext appContext) throws BeansException {
        context = appContext;
    }

}
