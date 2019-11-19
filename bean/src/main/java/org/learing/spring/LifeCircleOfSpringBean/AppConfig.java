package org.learing.spring.LifeCircleOfSpringBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {
    @Bean(initMethod = "initMethod",destroyMethod = "destroyMethod")
    public SpringBean springBean() {
        return new SpringBean();
    }
}
