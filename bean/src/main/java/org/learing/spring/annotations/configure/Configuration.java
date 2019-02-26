package org.learing.spring.annotations.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@org.springframework.context.annotation.Configuration
@ComponentScan("org.learing.spring.annotations.configure")
public class Configuration {
    @Bean(value = "person", initMethod = "init", destroyMethod = "destroy")
    public Person person01() {
        return new Person("xiaohong", 18);
    }
}
