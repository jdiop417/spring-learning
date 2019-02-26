package org.learing.spring.annotations.configure;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dog {

    public Dog() {
        System.out.println("dog....construct");
    }

    @PostConstruct
    public void init() {
        System.out.println("dog....PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("dog....PreDestroy");
    }
}
