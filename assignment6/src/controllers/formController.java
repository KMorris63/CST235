package controllers;

/*
 * Kacey Morris
 * December 9, 2020
 * CST 235 REST Services and Messages
 * 
 * This will control the buttons for all forms
 * 
 * This is my own work as influenced by class time and examples.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Order;
import beans.User;
import business.OrdersBusinessInterface;

@ManagedBean
@ViewScoped
public class formController {
	@Inject
	// interface for orders business service, no longer used in this assignment
	// because all orders displayed in the table are now from the database
	public OrdersBusinessInterface service;
	
	public String onSubmit(User user) {		
		// forward to test response view along with the user managed bean
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		// call business service to test and demo CDI
		service.test();
		
		// get orders from database, will print in console
		getAllOrders();
		
		// insert a new order
		// insertOrder();
		
		// get all orders again but set to display in table. will print in console
		service.setOrders(getAllOrders());
		// getAllOrders();
		
		// return the response page
		return "TestResponse.xhtml";
	}
		
	public OrdersBusinessInterface getService() {
		return service;
	}
	
	// gets orders from database
	private List<Order> getAllOrders() {
		// variables needed for connection to database
		Connection conn = null;
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "root";
		// sql query
		String sql = "SELECT * FROM testapp.ORDERS";
		// store the orders from the database
		List<Order> orders = new ArrayList<Order>();
		
		try {
			// connect to database
			conn = DriverManager.getConnection(url, username, password);
			// success message
			System.out.println("Connection successful!");
			
			// execute SQL Query and loop over result set
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			// for each item in the set that was returned from the query
			while (rs.next()) {
				// add to the list
				orders.add(new Order(
						rs.getString("ORDER_NO"),
						rs.getString("PRODUCT_NAME"),
						rs.getFloat("PRICE"),
						rs.getInt("QUANTITY")
									)						
				);
				// print the information from each item from the database
				System.out.println("ID: " + rs.getInt("ID") + ", OrderNum: " + rs.getString("ORDER_NO") + ", Name: " + 
				rs.getString("PRODUCT_NAME") + ", Price: " + rs.getFloat("PRICE") + ", Quantity: " + rs.getInt("QUANTITY"));
			}
			
			// close the result set
			rs.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Failed to get a connection.");
		}
		finally {
			// clean up database
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		// return the list of database orders
		return orders;
	}
	
	// insert an order into the database
	private void insertOrder() {
		// connection requirements
		Connection conn = null;
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "root";
		// sql statement to insert into the database
		String sql = "INSERT INTO testapp.ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES('001122334455', 'This was inserted new', 25.00, 100)";
		
		try {
			// get a connection and create a statement
			conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			// execute UPDATE this time to update the database
			stmt.executeUpdate(sql);
			// print positively
			System.out.println("Update success!");
		}
		catch (SQLException e) {
			// did not work, print negatively
			e.printStackTrace();
			System.out.println("Update failed.");
		}
		finally {
			// clean up
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public String onSendOrder() {
		// create default order
		Order order = new Order();
		// call service method to send the order
		service.sendOrder(order);
		
		// return order response page
		return "OrderResponse.xhtml";
	}
	
}

