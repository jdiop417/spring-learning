package org.learning.spring.beanFactoryPostProcessor.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.close();
    }
}
