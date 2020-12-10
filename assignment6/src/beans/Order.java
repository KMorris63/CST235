package beans;

/*
 * Kacey Morris
 * December 9, 2020
 * CST 235 REST Services and Messages
 * 
 * This outlines an order object.
 * 
 * This is my own work as influenced by class time and examples.
 */

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.xml.bind.annotation.XmlRootElement;

@ManagedBean
@XmlRootElement(name="Order")
public class Order implements Serializable {
	// properties
	String orderNum;
	String productName;
	float price;
	int quantity;
		
	// default constructor
	public Order() {
		orderNum = "1111";
		productName = "Test Object Message";
		price = 100;
		quantity = 100;
	}
		
	// data constructor
	public Order(String oNum, String pName, float passPrice, int quant) {
		orderNum = oNum;
		productName = pName;
		price = passPrice;
		quantity = quant;
	}
		
	// getters and setters
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
		
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
