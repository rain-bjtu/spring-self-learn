package spring.beans.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import spring.beans.inf.IHello;
import spring.beans.inf.IWho;

@Component("hello")
public class HelloImpl implements IHello {
	
	@Autowired
	private IWho who;
	
	@Value("${words}")
	private String words;
	
	@Value("${num}")
	private int num;
	

	@Override
	public void sayHello() {
		who.whoAmI();
		System.out.println(words);
	}

}
