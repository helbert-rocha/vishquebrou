package br.com.vishquebrou.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import br.com.vishquebrou.model.Employee;
import br.com.vishquebrou.model.dao.EmployeeDAO;
import br.com.vishquebrou.model.service.EmployeeService;
import br.com.vishquebrou.util.Crypto;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String address = "/WEB-INF/views/login.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username  = request.getParameter("username");
		String password = request.getParameter("password");
		
		//out.println(username);
		//out.println(password);
		
		EmployeeService employeeService = new EmployeeService();
		
		Employee employee = new Employee();
		
		employee = employeeService.getByProperty("username", username);
		
		if(employee != null){
			boolean pswd;
			 pswd = new Crypto().checkHash(password, employee.getPassword());
			 if(pswd){
					logged(request, response, employee.getFname(),username);
					//response.sendRedirect(getServletContext().getContextPath() + "/user");
				}else{
					loginFail(request, response, username);
				}
		}else{
			loginFail(request, response, username);
		}
	}
	
	private void logged(HttpServletRequest request, HttpServletResponse response, String fname, String username) throws ServletException, IOException{
		
		HttpSession session = request.getSession();
		session.setAttribute("user", fname);
		session.setAttribute("isLoggedIn", true);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		Cookie user = new Cookie("user", username);
		Cookie newdate = new Cookie("date", currentDate.toString());
		user.setMaxAge(3600*60*60);
		newdate.setMaxAge(3600*60*60);
		response.addCookie(user);
		response.addCookie(newdate);
		response.sendRedirect(getServletContext().getContextPath() + "/user");
	}
	
	private void loginFail(HttpServletRequest request, HttpServletResponse response, String username)throws ServletException, IOException{
		request.setAttribute("user", username);
		request.setAttribute("error", true);
		String address = "/WEB-INF/views/login.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}
}
