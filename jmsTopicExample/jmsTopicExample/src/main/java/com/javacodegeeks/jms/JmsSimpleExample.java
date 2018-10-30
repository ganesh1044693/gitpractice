package com.javacodegeeks.jms;

import java.net.URI;
import java.net.URISyntaxException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

public class JmsSimpleExample {

	public static void main(String[] args) throws URISyntaxException, Exception {

		BrokerService service = BrokerFactory.createBroker(new URI("broker:(tcp://localhost:61612)"));
		service.start();

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61612");
		Connection connection = connectionFactory.createConnection();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Topic topic = session.createTopic("FirstTopic");

		MessageConsumer consumer1 = session.createConsumer(topic);

		MessageConsumer consumer2 = session.createConsumer(topic);

		connection.start();
		String payLoad = "hello";
		TextMessage message = session.createTextMessage(payLoad);
		MessageProducer messageProducer = session.createProducer(topic);
		System.out.println("Sending text '" + payLoad + "'");
		messageProducer.send(message);
		Thread.sleep(10000);
		System.out.println();
		session.close();
		connection.close();
		service.stop();


	}
}
