package gmbh.db.simpleSpringDemo.hospital;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class HospitalConfig {

    @Bean
    @Profile("test")
    public String getRandomName() {
        return "Tim";
    }

    @Bean
    @Profile("default")
    public String getOtherName() {
        return "Dennis";
    }
}
