package org.learing.spring.annotations.configure;

import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean(value = "person")
    public Person person01() {
        return new Person("李明", 18);
    }
}
