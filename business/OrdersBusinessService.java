package business;

/*
 * Kacey Morris
 * November 8, 2020
 * CST 235 EJB and CDI
 * 
 * This class represents a business service with different dummy test data from the other business service. 
 * 
 * This is my own work, as influenced by class time and examples.
 */

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Order;

/**
 * Session Bean implementation class OrdersBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
@Alternative
public class OrdersBusinessService implements OrdersBusinessInterface {
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
		return this.orders;
	}

	@Override
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
    
    

}
