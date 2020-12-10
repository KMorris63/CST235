package business;

/*
 * Kacey Morris
 * December 9, 2020
 * CST 235 REST Services and Messages
 * 
 * The order message service listens for messages and prints to the console and updates the database.
 * 
 * This is my own work as influenced by class time and examples.
 */

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import beans.Order;
import database.OrdersDataService;

/**
 * Message-Driven Bean implementation class for: OrderMessageService
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/queue/Order"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "java:/jms/queue/Order")
// will listen for messages
public class OrderMessageService implements MessageListener {
	
	// data service to update the database
	OrdersDataService service = new OrdersDataService();

    /**
     * Default constructor. 
     */
    public OrderMessageService() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        try {
        	// if it is a text message
        	if (message instanceof TextMessage) {
        		// print the message to the console
        		System.out.println("***** OrderMessageService.onMessage with Text Message ***** " + ((TextMessage)message).getText());
        	}
        	else if (message instanceof ObjectMessage) {
        		// if an object message, print an update to the console
        		System.out.println("***** OrderMessageService.onMessage with a Send Order Message *****");
        		// add the object to the database
        		service.insertOrder((Order)((ObjectMessage)message).getObject());
        	}
        } catch (JMSException e) {
        	
        }
    }

}
