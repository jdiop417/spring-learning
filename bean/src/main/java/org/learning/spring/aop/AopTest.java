package org.learning.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext bf = new ClassPathXmlApplicationContext("aop.xml");
        TestBean bean = (TestBean) bf.getBean("testBean");
        bean.test();
    }
}
