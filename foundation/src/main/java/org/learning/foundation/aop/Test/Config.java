package org.learning.foundation.aop.Test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@ComponentScan(value = {"org.learing.spring.aop.Test"})
public class Config {

    @Bean
    public MathCalculator MathCalculator() {
        return new MathCalculator();
    }

    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }
}
