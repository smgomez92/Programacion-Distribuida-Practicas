package com.distribuida.servicios;

import java.sql.Connection;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;

import javax.jms.Message;
import javax.jms.MessageListener;

import com.distribuida.entidad.Persona;

/**
 * Message-Driven Bean implementation class for: ElminarMQ
 */
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "eliminarQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class ElminarMQ implements MessageListener {
	@EJB
	private MantenerPersonaRemote man;

	public ElminarMQ() {

	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {
		Persona msg = null;
		Connection c = null;
		try {
			if (message instanceof Persona) {
				msg = (Persona) message;

				man.eliminar(msg.getId(), c);

			} else {
				System.err.println("El mensaje no es de tipo texto");
			}
		} catch (Exception e) {
			System.err.println("JMSException en onMessage(): " + e.toString());
		} catch (Throwable t) {
			System.err.println("Exception en onMessage():" + t.getMessage());
		}

	}

}
