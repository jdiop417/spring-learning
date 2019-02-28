package org.learing.spring.eventMulticaster.test;

import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        context.publishEvent(new ApplicationEvent("我发布的事件") {
        });

        context.close();
    }
}
