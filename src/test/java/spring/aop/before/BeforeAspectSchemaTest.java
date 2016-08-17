package spring.aop.before;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.before.ISay;
import common.util.SeparatorUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BeforeAspectSchemaTest {

    private static boolean print = true;

    @Test
    public void testAppXML1() {
        SeparatorUtil.printMethodSeparator();
        String appConfig = "spring/aop/before/aop-param-correct1.xml";
        try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(appConfig)) {
            ISay say = (ISay) context.getBean("say");
            say.say("Hello", "Judy");
            SeparatorUtil.printMethodInnerSeparator();
            say.say();
        }
    }

    @Test
    public void testAppXML2() {
        boolean result = false;
        SeparatorUtil.printMethodSeparator();
        String appConfig = "spring/aop/before/aop-param-correct2.xml";
        try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(appConfig)) {
            ISay say = (ISay) context.getBean("say");
            say.say("Hello", "Judy");
            SeparatorUtil.printMethodInnerSeparator();
            say.say();
            result = true;
        } catch (Exception e) {
            if (print)
                e.printStackTrace();
        }
        Assert.assertTrue(result);
    }

    @Test
    public void testAppXML3() {
        boolean result = false;
        SeparatorUtil.printMethodSeparator();
        String appConfig = "spring/aop/before/aop-param-wrong1.xml";
        try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(appConfig)) {
            ISay say = (ISay) context.getBean("say");
            say.say("Hello", "Judy");
            SeparatorUtil.printMethodInnerSeparator();
            say.say();
            result = true;
        } catch (Exception e) {
            if (print)
                e.printStackTrace();
        }
        Assert.assertFalse(result);
    }

    @Test
    public void testAppXML4() {
        boolean result = false;
        SeparatorUtil.printMethodSeparator();
        String appConfig = "spring/aop/before/aop-param-wrong2.xml";
        try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(appConfig)) {
            ISay say = (ISay) context.getBean("say");
            say.say("Hello", "Judy");
            SeparatorUtil.printMethodInnerSeparator();
            say.say();
            result = true;
        } catch (Exception e) {
            if (print)
                e.printStackTrace();
        }
        Assert.assertFalse(result);
    }

    @Test
    public void testAppXML5() {
        boolean result = false;
        SeparatorUtil.printMethodSeparator();
        String appConfig = "spring/aop/before/aop-param-correct3.xml";
        try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(appConfig)) {
            ISay say = (ISay) context.getBean("say");
            say.say("Hello", "Judy");
            SeparatorUtil.printMethodInnerSeparator();
            say.say();
            result = true;
        } catch (Exception e) {
            if (print)
                e.printStackTrace();
        }
        Assert.assertTrue(result);
    }

    @Test
    public void testAppXML6() {
        boolean result = false;
        SeparatorUtil.printMethodSeparator();
        String appConfig = "spring/aop/before/aop-param-correct4.xml";
        try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(appConfig)) {
            ISay say = (ISay) context.getBean("say");
            say.say("Hello", "Judy");
            SeparatorUtil.printMethodInnerSeparator();
            say.say();
            result = true;
        } catch (Exception e) {
            if (print)
                e.printStackTrace();
        }
        Assert.assertTrue(result);
    }

    @Test
    public void testAppXML7() {
        boolean result = false;
        SeparatorUtil.printMethodSeparator();
        String appConfig = "spring/aop/before/aop-param-wrong3.xml";
        try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(appConfig)) {
            ISay say = (ISay) context.getBean("say");
            say.say("Hello", "Judy");
            SeparatorUtil.printMethodInnerSeparator();
            say.say();
            result = true;
        } catch (Exception e) {
            if (print)
                e.printStackTrace();
        }
        Assert.assertFalse(result);
    }
}
