package org.learing.spring.jms.java;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Receiver {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("my-queue");
        MessageConsumer consumer = session.createConsumer(queue);
        int i = 0;
        while (i < 3) {
            i++;
            TextMessage message = (TextMessage) consumer.receive();
            session.commit();
            System.out.println("收到消息：" + message.getText());
        }
        session.close();
        connection.close();
    }
}
