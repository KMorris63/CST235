package beans;

public class Order {
	String orderNum;
	String productName;
	float price;
	int quantity;
	
	// default constructor
	public Order() {
		orderNum = "";
		productName = "";
		price = 0;
		quantity = 0;
	}
	
	// data constructor
	public Order(String oNum, String pName, float passPrice, int quant) {
		orderNum = oNum;
		productName = pName;
		price = passPrice;
		quantity = quant;
	}
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
