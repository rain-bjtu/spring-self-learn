package method.inject.lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class CommandManager {

    @Lookup("asyncCommand")
    public abstract Command createCommand();

    public Object process() {
        Command command = createCommand();
        return command.execute();
    }
}
