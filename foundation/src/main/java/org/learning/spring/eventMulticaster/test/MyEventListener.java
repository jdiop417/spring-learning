package org.learning.spring.eventMulticaster.test;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

//@Component
public class MyEventListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {

        System.out.println("收到事件：" + event);
    }
}
