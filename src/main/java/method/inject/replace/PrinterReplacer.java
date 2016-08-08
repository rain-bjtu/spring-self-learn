package method.inject.replace;

import java.lang.reflect.Method;
import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.stereotype.Component;

@Component("replacer")
public class PrinterReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("This is Printer Replacer!");
        System.out.println(args[0]);
        System.out.println(args[1]);
        return null;
    }

}
