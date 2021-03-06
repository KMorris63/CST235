package beans;

/*
 * Kacey Morris
 * December 9, 2020
 * CST 235 REST Services and Messages
 * 
 * This outlines a user object.
 * 
 * This is my own work as influenced by class time and examples.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
@SessionScoped
public class User {
	// properties
	// bean validation annotations
	@NotNull (message="First Name cannot be empty!")
	@Size(min=5, max=15, message="First Name must be between 5 and 15 characters.")
	String firstName = "";
	
	@NotNull (message="First Name cannot be empty!")
	@Size(min=5, max=15, message="Last Name must be between 5 and 15 characters.")
	String lastName = "";
	
	// constructor
	public User() {
		// must be null in constructor to trigger "@NotNull" checking 
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
