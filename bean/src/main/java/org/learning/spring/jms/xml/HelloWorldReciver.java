package org.learning.spring.jms.xml;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

public class HelloWorldReciver {
    public static void main(String[] args) throws JMSException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jms.xml");
        JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
        Destination destination = (ActiveMQQueue) context.getBean("destination");
        TextMessage msg = (TextMessage) jmsTemplate.receive(destination);
        System.out.println("recived msg is:" + msg.getText());

    }
}
