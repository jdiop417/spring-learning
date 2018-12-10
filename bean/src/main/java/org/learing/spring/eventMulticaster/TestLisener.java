package org.learing.spring.eventMulticaster;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class TestLisener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        TestEvent testEvent = (TestEvent) event;
        testEvent.print();
    }
}
