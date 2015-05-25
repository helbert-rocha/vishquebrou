package br.com.vishquebrou.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vishquebrou.model.*;
import br.com.vishquebrou.model.service.EmployeeService;
import br.com.vishquebrou.model.service.EnterpriseService;
import br.com.vishquebrou.model.service.InfoService;
import br.com.vishquebrou.util.Crypto;

/**
 * Servlet implementation class CreateDB
 */
@WebServlet("/CreateDB")
public class CreateDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateDBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		createDB();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		createDB();
	}
	
	private void createDB(){
			
			EnterpriseService enService = new EnterpriseService();
			EmployeeService emService = new EmployeeService();
			InfoService inService = new InfoService();
		
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			String currentDate = dateFormat.format(date);
			
			
			String password = new Crypto().encrypt("12345");
		
			
			Enterprise enterprise = new Enterprise("VishQuebrou", "TI", "Paraná", "Pinhão", "Centro");
			Employee employee = new Employee("Helbert", "da Rocha", "helbert", password, "helberti@hotmail.com", enterprise);
			Info info = new Info("Quebrou",  currentDate ,"send", enterprise);
			
			enService.save(enterprise);
			emService.save(employee);
			inService.save(info);
			
			
			System.out.println("aki o/!");
			
			
	}

}
