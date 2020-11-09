package business;

/*
 * Kacey Morris
 * November 8, 2020
 * CST 235 EJB and CDI
 * 
 * This interface outlines what methods each business service should implement.
 * 
 * This is my own work, as influenced by class time and examples.
 */

import java.util.List;

import javax.ejb.Local;

import beans.Order;

@Local
public interface OrdersBusinessInterface {
	public void test();
	public List<Order> getOrders();
	public void setOrders(List<Order> orders);
}
