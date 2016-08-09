package spring.bean.basic;

import java.net.URL;

import org.junit.Test;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import spring.beans.inf.IHello;

public class SpringBeanTest {

    @Test
    public void testSpringBeanFactory() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml");
        IHello hello = context.getBean(IHello.class);
        IHello hello2 = context.getBean("hello", IHello.class);

        hello.sayHello();
        hello2.sayHello();

        System.out.println(hello == hello2);

        AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext();
        Resource r = new FileSystemResource(getClass().getResource("/app.properties").getPath());
        PropertyPlaceholderConfigurer pphc = new PropertyPlaceholderConfigurer();
        pphc.setLocation(r);
        pphc.postProcessBeanFactory(context2.getBeanFactory());
        // context2.addBeanFactoryPostProcessor(pphc);
        context2.scan("spring.beans.impl", "spring.beans.config");
        // context2.register(BeansConfiguration.class);

        // for (BeanFactoryPostProcessor bfpp :
        // context2.getBeanFactoryPostProcessors()) {
        // if (bfpp instanceof PropertyPlaceholderConfigurer) {
        // System.out.println("find!");
        // Resource r = new
        // FileSystemResource(BeansConfiguration.class.getResource("app.properties").getPath());
        // ((PropertyPlaceholderConfigurer) bfpp).setLocation(r);
        // }
        // }

        context2.refresh();

        IHello hello3 = context2.getBean(IHello.class);
        hello3.sayHello();

        System.out.println(hello == hello3);

        String a = (String) context2.getBean("judy");
        System.out.println(a);

        if (context instanceof ConfigurableApplicationContext) {
            ((ConfigurableApplicationContext) context).close();
        }
        if (context2 instanceof ConfigurableApplicationContext) {
            ((ConfigurableApplicationContext) context2).close();
        }

    }
}
