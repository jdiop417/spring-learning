package org.learning.spring.annotations.configure;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);
        Person person = (Person) context.getBean("person");
        System.out.println(person.toString());
        context.close();
    }
}
