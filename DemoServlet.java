package assignment2a;

/*
 * Kacey Morris
 * October 11, 2020
 * CST 235 Application Design and Implementation Part 1
 * This is a program which tests initialization, destroy, and doGet, displaying messages in the console at each
 * key section of the page deployment.
 * This is my own work, as influenced by class time and examples and the textbook.
 */

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// message in console for initialization
		System.out.println("-----------This is the INITIALIZATION");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// message in console for destroy
		System.out.println("-----------I WILL DESTROY YOU!!!*********");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// must call super for doGet to work
		super.service(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// to be passing parameters
		// ?firstname=Kacey&lastname=Morris
		// get the first and last name from parameters
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		
		// displayed on the page
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("<br>Your name is " + firstName + " " + lastName + "<br>");
		
		// request.setAttribute("firstname", firstName);
		// request.setAttribute("lastname", lastName);
		// request.getRequestDispatcher("ResponsePage.jsp").forward(request, response);
		
		// displayed in the console
		System.out.println("This is my servlet! Hello World!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
