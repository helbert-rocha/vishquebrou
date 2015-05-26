package br.com.vishquebrou.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.vishquebrou.model.Employee;
import br.com.vishquebrou.model.Enterprise;
import br.com.vishquebrou.model.Info;
import br.com.vishquebrou.model.service.EmployeeService;
import br.com.vishquebrou.model.service.EnterpriseService;
import br.com.vishquebrou.model.service.InfoService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession session = ((HttpServletRequest)request).getSession();
		
		String username;
		
		username = session.getAttribute("user") == null ? null : session.getAttribute("user").toString();
		//out.println(username);
		Employee employee = new Employee();
		
		EmployeeService employeeService = new EmployeeService();
		employee = employeeService.getByProperty("username", username);
		request.setAttribute("employee", employee);	
		InfoService infoService = new InfoService();
		Long enId = employee.getEnterprise().getId();
		
		ArrayList<Info> infos = (ArrayList<Info>) infoService.findAllById("enterprise", enId);
		
		request.setAttribute("infos", infos);
		
		String address = "/WEB-INF/views/user.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
