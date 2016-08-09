package spring.beans.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@Configuration
public class BeansConfiguration {

    @Bean
    public String judy() {
        return "Judy";
    }

    // @Bean
    // public PropertyPlaceholderConfigurer propertyConfig() {
    // // Properties props = new Properties();
    // // try {
    // // String url =
    // BeansConfiguration.class.getResource("app.properties").getPath();
    // // props.load(new FileInputStream(url));
    // // System.out.println(props.getProperty("num"));
    // // } catch (IOException e) {
    // // // TODO Auto-generated catch block
    // // e.printStackTrace();
    // // }
    // PropertyPlaceholderConfigurer properyConfig = new
    // PropertyPlaceholderConfigurer();
    // // properyConfig.setProperties(props);
    // Resource r = new
    // FileSystemResource(BeansConfiguration.class.getResource("app.properties").getPath());
    // properyConfig.setLocation(r);
    // return properyConfig;
    // }
}
