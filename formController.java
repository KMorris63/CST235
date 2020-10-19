package controllers;

/*
 * Kacey Morris
 * October 14, 2020
 * CST 235 Application Grid
 * 
 * This class creates a method to be called when a submit button is pressed.
 * 
 * This is my own work, as influenced by class time and examples.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.User;

@ManagedBean
@ViewScoped
public class formController {
	// legacy
	public String onSubmit(User user) {
		// forward to test response view along with the user managed bean
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		// return the response page
		return "TestResponse.xhtml";
	}
		
	
	
}
