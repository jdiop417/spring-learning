package org.learning.foundation.eventMulticaster.test;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Blue {
    public Blue() {
        System.out.println("blue....construct");

    }

    @PostConstruct
    public void init() {
        System.out.println("blue....PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("blue....PreDestroy");
    }
}
