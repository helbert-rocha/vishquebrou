package br.com.vishquebrou.model.service;

import br.com.vishquebrou.model.Enterprise;
import br.com.vishquebrou.model.dao.EnterpriseDAO;
import br.com.vishquebrou.util.JPAUtil;

public class EnterpriseService extends AbstractService<Long, Enterprise>{

	public EnterpriseService() {
		dao = new EnterpriseDAO();
	} 
}
