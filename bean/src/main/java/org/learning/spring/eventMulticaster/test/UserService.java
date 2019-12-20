package org.learning.spring.eventMulticaster.test;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @EventListener(classes = {ApplicationEvent.class})
    public void eventLisenter(ApplicationEvent event) {
        System.out.println("UserService....收到事件：" + event);
    }
}
