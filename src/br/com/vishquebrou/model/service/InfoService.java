package br.com.vishquebrou.model.service;

import br.com.vishquebrou.model.Info;
import br.com.vishquebrou.model.dao.InfoDAO;
import br.com.vishquebrou.util.JPAUtil;

public class InfoService extends AbstractService<Long, Info>{
	public InfoService() {
		dao = new InfoDAO();
	}
}
