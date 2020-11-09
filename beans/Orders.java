package beans;

/*
 * Kacey Morris
 * November 8, 2020
 * CST 235 EJB and CDI
 * 
 * This class is no longer used in this activity. The same functionality is demonstrated with the business services. 
 * 
 * This is my own work, as influenced by class time and examples.
 */

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Orders {
	List<Order> orders = new ArrayList<Order>();
	
	public Orders() {
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
	}

	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
