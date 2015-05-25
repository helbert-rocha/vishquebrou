package br.com.vishquebrou.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import antlr.collections.List;
import br.com.vishquebrou.model.Employee;
import br.com.vishquebrou.model.Enterprise;
import br.com.vishquebrou.model.Info;
import br.com.vishquebrou.model.service.EmployeeService;
import br.com.vishquebrou.model.service.EnterpriseService;
import br.com.vishquebrou.model.service.InfoService;

/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/info")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EnterpriseService enterpriseService = new EnterpriseService();
		
		
		ArrayList<Enterprise> enList = (ArrayList<Enterprise>) enterpriseService.findAll();
		request.setAttribute("enterprises", enList);
		String address = "/WEB-INF/views/info.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String descryption  = request.getParameter("what");
		String newEnterprise = request.getParameter("enterprise");
		
		Long enterId = Long.parseLong(newEnterprise);
		
		
		EnterpriseService enterpriseService = new EnterpriseService();
		Enterprise enterprise = new Enterprise();
		enterprise = enterpriseService.getById(enterId);
		out.println(descryption);
		out.println(enterprise);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		InfoService infoService = new InfoService();
		Info info = new Info(descryption,currentDate,"new",enterprise);
		infoService.save(info);
		String address = "/WEB-INF/views/thanks.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

}
