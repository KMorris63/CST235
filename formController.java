package controllers;

/*
 * Kacey Morris
 * October 11, 2020
 * CST 235 Application Design and Implementation Part 1
 * This is a program which sends the form input to the correct page, depending on the button.
 * This is my own work, as influenced by class time and examples and the textbook.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.User;

@ManagedBean
@ViewScoped
public class formController 
{
	// legacy
	public String onSubmit() {
		// get the User Managed Bean
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		// forward to Test Response View along with the User Managed Bean
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		return "TestResponse.xhtml";
	}
	
	
	public String onSubmit(User user) {
		// forward to test response view along with the user managed bean
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		return "TestResponse.xhtml";
	}
	
	public String onFlash(User user) {
		// redirect to test response view using flash scope with the user managed bean
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("user", user);
		return "TestResponse2.xhtml?faces-redirect=true";
		}
}
