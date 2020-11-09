package controllers;

/*
 * Kacey Morris
 * November 8, 2020
 * CST 235 EJB and CDI
 * 
 * This class controls the form and calls the business service and timer.
 * 
 * This is my own work, as influenced by class time and examples.
 */

import javax.ejb.EJB;

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
import javax.inject.Inject;

import beans.User;
import business.MyTimerService;
import business.OrdersBusinessInterface;

@ManagedBean
@ViewScoped
public class formController {
	@Inject
	public OrdersBusinessInterface service;
	
	@EJB
	public MyTimerService timer;
	
	public String onSubmit(User user) {		
		// forward to test response view along with the user managed bean
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		// call business service to test and demo CDI
		service.test();
				
		// start a timer when the login is clicked
		timer.setTimer(10000);
		
		// return the response page
		return "TestResponse.xhtml";
	}
		
	public OrdersBusinessInterface getService() {
		return service;
	}
	
}
