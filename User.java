package beans;

/*
 * Kacey Morris
 * October 11, 2020
 * CST 235 Application Design and Implementation Part 1
 * This is a class which represents a user. 
 * This is my own work, as influenced by class time and examples and the textbook.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

// managed bean and view scoped
@ManagedBean
@ViewScoped
public class User {
	// properties
	String firstName = "";
	String lastName = "";
	
	// constructor
	public User() {
		firstName = "Kacey";
		lastName = "Morris";
	}

	// getters and setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}