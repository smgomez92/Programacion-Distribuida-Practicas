package com.practica.mensajeria;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;


import com.practica.servicios.Operaciones;
import com.practica.servicios.OperacionesImpl;

public class Consumer {
	private static String SIN_RESPUESTA = "sin respuesta";

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

	public static String calcular(int timeout) throws JMSException, IOException {
		System.out.println("calcular");
		String resp = SIN_RESPUESTA;
		Message message = messageConsumer.receive(timeout);
		Operaciones servicio = new OperacionesImpl();
		while (true) {
			System.out.println("while");
			if (message != null) {
				System.out.println("bloque if ");
				// cast the message to the correct type
				TextMessage textMessage = (TextMessage) message;
				// retrieve the message content
				String text = textMessage.getText();
				String arreglo[] = text.split(",");
				float respuesta = servicio.suma(Float.parseFloat(arreglo[0]), Float.parseFloat(arreglo[1]));

				File f = new File("respuesta");
				f.mkdir();
				File fichero = new File(f, "resp.txt");
				fichero.createNewFile();
				FileWriter fw = new FileWriter(fichero, false);
				PrintWriter salida = new PrintWriter(fw);
				salida.println("Resultado= " + respuesta);
				salida.flush();
				salida.close();
				System.out.println("Se ha guardado el resultado en el fichero " + f.getAbsolutePath());

				resp = text;
			} else {
				//System.out.println("consumer no ha recepcionado ningun mensaje");
			}
			return resp;
		}

	}

	public static void main(String[] args) throws JMSException, IOException {
		
		//while (true) {
			create("Operaciones");
			String greeting = calcular(1000);
			close();
			System.out.println(greeting);
			
		//}

	}

}
