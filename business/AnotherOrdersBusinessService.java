package business;

/*
 * Kacey Morris
 * November 8, 2020
 * CST 235 EJB and CDI
 * 
 * This class represents another business service. 
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
 * Session Bean implementation class AnotherOrdersBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
@Alternative
public class AnotherOrdersBusinessService implements OrdersBusinessInterface {
	List<Order> orders = new ArrayList<Order>();
    /**
     * Default constructor. 
     */
    public AnotherOrdersBusinessService() {
    	// "dummy" test data
    	orders.add(new Order("00001", "Shirt", (float)15.00, 3));
    	orders.add(new Order("00002", "Potted Plant", (float)5.00, 2));
    	orders.add(new Order("00003", "Fake Flowers", (float)1.00, 1));
    	orders.add(new Order("00004", "Red Rose", (float)5.00, 5));
    	orders.add(new Order("00005", "Nail Polish", (float)3.00, 2));
    	orders.add(new Order("00006", "Apple", (float)1.00, 4));
    	orders.add(new Order("00007", "Necklace", (float)25.00, 1));
    	orders.add(new Order("00008", "Brush", (float)4.00, 1));
    	orders.add(new Order("00009", "Backpack", (float)25.00, 1));
    	orders.add(new Order("00010", "Ring", (float)15.00, 1));
    }

	/**
     * @see OrdersBusinessInterface#test()
     */
    public void test() {
        System.out.println("Hello from AnotherOrderBusinessService");
    }

    // getter and setter
	@Override
	public List<Order> getOrders() {
		return this.orders;
	}

	@Override
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
