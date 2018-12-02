package org.learing.spring.EventMulticaster;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("eventMulticaster.xml");
        TestEvent testEvent = new TestEvent("hello", "msg");
        context.publishEvent(testEvent);
    }
}
