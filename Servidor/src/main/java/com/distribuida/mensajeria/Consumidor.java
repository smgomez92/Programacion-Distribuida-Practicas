package com.distribuida.mensajeria;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.distribuida.entidad.Persona;
import com.distribuida.servicios.Mantenimiento;
import com.distribuida.servicios.MantenimientoImpl;




public class Consumidor {
	private static Connection connection;
	private static MessageConsumer messageConsumer;

	public static void create(String destinationName) throws JMSException {
		System.out.println("create()");
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		connection = connectionFactory.createConnection();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue(destinationName);
		messageConsumer = session.createConsumer(destination);
		connection.start();
	}

	public static void close() throws JMSException {
		connection.close();
	}

	public static String consultar(int timeout) throws JMSException, IOException {
		System.out.println("calcular");
		String resp = "no responde";
		Message message = messageConsumer.receive(timeout);
		Mantenimiento man =new MantenimientoImpl();
			java.sql.Connection c=null;
			
		while (true) {
			
			if (message != null) {
				System.out.println("bloque if ");
				// cast the message to the correct type
				TextMessage textMessage = (TextMessage) message;
				// retrieve the message content
				String text = textMessage.getText();
				String arreglo[] = text.split(",");
				
				man.borrar(Integer.parseInt(arreglo[0]),c );

				

				resp = text;
			} else {
				//
			}
			return resp;
		}
		
}}
