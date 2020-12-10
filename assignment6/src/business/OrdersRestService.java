package business;

/*
 * Kacey Morris
 * December 9, 2020
 * CST 235 REST Services and Messages
 * 
 * The rest service allows for the database information to be seen in json and xml format.
 * 
 * This is my own work as influenced by class time and examples.
 */

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Order;

// annotations
@RequestScoped
@Path("/orders")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class OrdersRestService {
	// use the business service
	@Inject
	OrdersBusinessInterface bs;
	
	// get all records and display them in json format
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getOrdersAsJson() {
		return bs.getOrders();
	}
	
	// get all records and display them in json format
	@GET
	@Path("/getxml")
	@Produces(MediaType.APPLICATION_XML)
	public Order[] getOrdersAsXML() {
		List<Order> orders = bs.getOrders();
		// must convert to array
		return orders.toArray(new Order[orders.size()]);
	}
}
