package business;

/*
 * Kacey Morris
 * December 9, 2020
 * CST 235 REST Services and Messages
 * 
 * This is an orders business service which implements the orders business interface.
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

	@Override
	public List<Order> getOrders() {
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
		// set the orders
		this.setOrders(orders);
		
		// return the list of database orders
		return this.orders;
	}

	@Override
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public void sendOrder(Order order) {
		
	}

}

