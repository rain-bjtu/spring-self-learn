package method.inject.replace;

import org.springframework.stereotype.Component;

@Component("printer")
public class PrinterImpl implements IPrinter {

    @Override
    public void print(String s, int i) {
        System.out.println("This will not print: " + s + " : " + i);
    }

}
