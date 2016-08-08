package property.placeholder.value;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/property/placeholder/value/app.properties")
public class ExpressiveConfig {

    @Autowired
    Environment env;

    @Bean
    public CompactDisc disc() {
        return new BlankDisc(env.getProperty("blank.title"), env.getProperty("blank.artist"));
    }
}