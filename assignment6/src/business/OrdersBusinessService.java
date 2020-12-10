package business;

/*
 * Kacey Morris
 * December 9, 2020
 * CST 235 REST Services and Messages
 * 
 * This is the main orders business service.
 * 
 * This is my own work as influenced by class time and examples.
 */

import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import beans.Order;

/**
 * Session Bean implementation class OrdersBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@Alternative
@LocalBean
public class OrdersBusinessService implements OrdersBusinessInterface {
	
	// resources for messages
	@Resource(mappedName="java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName="java:/jms/queue/Order")
	private Queue queue;

	
	List<Order> orders = new ArrayList<Order>();
    /**
     * Default constructor. 
     */
    public OrdersBusinessService() {
    	// "dummy" test data
    	orders.add(new Order("00011", "Dress", (float)60.00, 3));
    	orders.add(new Order("00012", "Decorative Crystal", (float)75.00, 2));
    	orders.add(new Order("00013", "Acrylic Nails", (float)65.00, 1));
    	orders.add(new Order("00014", "Dozen Roses", (float)60.00, 5));
    	orders.add(new Order("00015", "Caviar", (float)30.00, 2));
    	orders.add(new Order("00016", "Filet Mignon", (float)60.00, 4));
    	orders.add(new Order("00017", "Diamond Ring", (float)700.00, 1));
    	orders.add(new Order("00018", "Hair Extensions", (float)100.00, 1));
    	orders.add(new Order("00019", "Purse", (float)300.00, 1));
    }

	/**
     * @see OrdersBusinessInterface#test()
     */
    public void test() {
        System.out.println("Hello from the OrdersBusinessService");
    }

	@Override
	public List<Order> getOrders() {	
		// return the list of database orders
		return this.orders;
	}

	@Override
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public void sendOrder(Order order) {
		// Send a Message for an Order
		try 
		{
			// establish a connection
			Connection connection = connectionFactory.createConnection();
			// start a session
			Session session = ((javax.jms.Connection) connection).createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			// allow for messages to be produced and set the queue
			MessageProducer messageProducer = session.createProducer(queue);
			
			// first message is text
			TextMessage message1 = session.createTextMessage();
			// set the message
			message1.setText("This is test message");
			// send a text message
			messageProducer.send(message1);
			
			// second message is an object
			ObjectMessage message2 = session.createObjectMessage();
			// set the object for the message
			message2.setObject(order);
			// send the object message
			messageProducer.send(message2);
			
			// secure connection
			connection.close();
		} 
		catch (JMSException e) 
		{
			e.printStackTrace();
		}
	}
}
