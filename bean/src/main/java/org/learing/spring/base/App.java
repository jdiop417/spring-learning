package org.learing.spring.base;


import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beanFactory.xml");
        User user = ctx.getBean("user", User.class);
        System.out.println(user.getUsername());
    }
}
