package br.com.vishquebrou.model.service;

import br.com.vishquebrou.model.Employee;
import br.com.vishquebrou.model.dao.EmployeeDAO;
import br.com.vishquebrou.util.JPAUtil;

public class EmployeeService extends AbstractService<Long, Employee>{
	public EmployeeService () {
		dao = new EmployeeDAO();
	}
}
