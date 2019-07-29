package com.practica.mensajeria;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {
	private static Connection connection;
	private static Session session;
	private static MessageProducer messageProducer;
	private static Scanner teclado;

	
	/**
	 * Creacion de un productor
	 * */
	public static void create(String destinationName) throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		connection = connectionFactory.createConnection();
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue(destinationName);
		messageProducer = session.createProducer(destination);
		
	}

	public static void close() throws JMSException {
		connection.close();
	}

	public static void sumar(int numUno, int numDos) throws JMSException {
		System.out.println("Sumar");
		String respuesta = numUno + "," + numDos;
		TextMessage textMessage = session.createTextMessage(respuesta);
		System.out.println(respuesta+" "+textMessage.getText()+""+messageProducer.toString());
		messageProducer.send(textMessage);
		
	}

	public static void main(String[] args) throws JMSException {
		String resp = null;
		operar();
		System.out.println("Desea realizar una nueva suma? s/n");
		resp = teclado.next();
		while(!resp.equalsIgnoreCase("n")) {
			operar();
			System.out.println("Desea realizar una nueva suma? s/n");
			resp = teclado.next();
		}

	}

	public static void operar() throws JMSException {
		System.out.println("operar");
		create("Operaciones");
		teclado = new Scanner(System.in);
		System.out.println("Ingrese el primer numero:");
		int numUno = teclado.nextInt();
		System.out.println("Ingrese el segundo numero:");
		int numDos = teclado.nextInt();
		sumar(numUno, numDos);
		System.out.println("Se ha enviado la peticion a la cola");
		close();
	}

}

