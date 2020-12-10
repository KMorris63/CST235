package business;

/*
 * Kacey Morris
 * December 9, 2020
 * CST 235 REST Services and Messages
 * 
 * This is the interface for all business services.
 * 
 * This is my own work as influenced by class time and examples.
 */

import java.util.List;

import javax.ejb.Local;

import beans.Order;

@Local
public interface OrdersBusinessInterface {
	// required methods
	public void test();
	public List<Order> getOrders();
	public void setOrders(List<Order> orders);
	public void sendOrder(Order order);
}
