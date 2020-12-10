package database;

/*
 * Kacey Morris
 * December 9, 2020
 * CST 235 REST Services and Messages
 * 
 * This will access and update the database. 
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

import beans.Order;

public class OrdersDataService {
	// gets orders from database
	public List<Order> getAllOrders() {
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
	public void insertOrder(Order order) {
	// connection requirements
		Connection conn = null;
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "root";
		// sql statement to insert into the database
		String sql = "INSERT INTO testapp.ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES('" + order.getOrderNum() + "', '" + order.getProductName() + "', " + order.getPrice() + ", " + order.getQuantity() + ")";
		
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
}
