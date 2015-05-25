package br.com.vishquebrou.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vishquebrou.model.Employee;
import br.com.vishquebrou.model.Enterprise;
import br.com.vishquebrou.model.service.EmployeeService;
import br.com.vishquebrou.model.service.EnterpriseService;
import br.com.vishquebrou.util.Crypto;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/WEB-INF/views/register.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confPassword = request.getParameter("confPassword");
		String enterprise = request.getParameter("enterprise");
		String type = request.getParameter("type");		
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String district = request.getParameter("district");
		
		Employee checkEmployee = new Employee();
		Employee checkemail = new Employee();
		int errors = 0;
		checkEmployee = new EmployeeService().getByProperty("username", username);
		checkemail = new EmployeeService().getByProperty("email", email);
		request.setAttribute("fname", fname);
		request.setAttribute("username", username);
		request.setAttribute("lname", lname);
		request.setAttribute("email", email);
		request.setAttribute("enterprise", enterprise);
		request.setAttribute("type", type);
		request.setAttribute("state", state);
		request.setAttribute("city", city);
		request.setAttribute("district", district);
		
		if(!password.equals(confPassword)){
			request.setAttribute("errorPswd", true);
			errors = errors +1;
		}
		if(checkEmployee != null){
			request.setAttribute("errorUsername", true);
			errors = errors +1;
		}
		if(checkemail != null){
			request.setAttribute("errorEmail", true);
			errors = errors +1;
		}
		
		if(errors > 0){
			String address = "/WEB-INF/views/register.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
			
		}else{
			String pswd = new Crypto().encrypt(password);
			EnterpriseService enService = new EnterpriseService();
			EmployeeService  emService =  new EmployeeService();
			
			Enterprise newEnterprise = new Enterprise(enterprise, type,state,city,district);
			Employee employee = new Employee(fname, lname, username, pswd, email, newEnterprise);
			
			enService.save(newEnterprise);
			emService.save(employee);
			
			response.sendRedirect(getServletContext().getContextPath() + "/login");
		}
	}
}
