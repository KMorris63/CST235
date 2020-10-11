package assignment2a;

/*
 * Kacey Morris
 * October 11, 2020
 * CST 235 Application Design and Implementation Part 1
 * This is a program which handles form input and sends that input to the correct page.
 * This is my own work, as influenced by class time and examples and the textbook.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

/**
 * Servlet implementation class HandleFormInput
 */
@WebServlet("/HandleFormInput")
public class HandleFormInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleFormInput() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the first and last name
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		
		// if they submitted empty parameters, send to the error page
		if (firstName.trim().equals("") || firstName == null || lastName.trim().equals("") || lastName == null) {
			request.getRequestDispatcher("TestError.jsp").forward(request, response);
		}
		
		// set attributes to send
		request.setAttribute("firstname", firstName);
		request.setAttribute("lastname", lastName);
		// send to the success page, displaying user name
		request.getRequestDispatcher("ResponsePage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
