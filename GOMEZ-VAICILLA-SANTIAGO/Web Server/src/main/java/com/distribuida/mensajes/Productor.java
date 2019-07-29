package com.distribuida.mensajes;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.distribuida.entidad.Persona;

public class Productor {
	private  Connection connection;
	private  Session session;
	private  MessageProducer messageProducer;
	private  Scanner teclado;

	/**
	 * Creacion de un productor
	 */
	public  void create(String destinationName) throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		connection = connectionFactory.createConnection();
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue(destinationName);
		messageProducer = session.createProducer(destination);

	}

	public  void close() throws JMSException {
		connection.close();
	}

	public  void borra(Persona p) throws JMSException {

		String respuesta = p.toString();
		TextMessage textMessage = session.createTextMessage(respuesta);
		messageProducer.send(textMessage);

	}

}
