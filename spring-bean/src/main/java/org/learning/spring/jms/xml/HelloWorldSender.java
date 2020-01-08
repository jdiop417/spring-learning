package org.learning.spring.jms.xml;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

public class HelloWorldSender {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jms.xml");
        JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
        Destination destination = (ActiveMQQueue) context.getBean("destination");
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("大家好，这是个测试");
            }
        });
    }
}
