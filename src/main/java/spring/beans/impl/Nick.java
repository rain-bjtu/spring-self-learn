package spring.beans.impl;

import org.springframework.stereotype.Component;

import spring.beans.inf.IWho;

@Component("nick")
public class Nick implements IWho {
    private String name = "Nick";

    @Override
    public String whoAmI() {
        System.out.println("I am " + name + "! ");
        return name;
    }

}
