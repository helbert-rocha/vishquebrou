package br.com.vishquebrou.model.service;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.vishquebrou.model.*;
import br.com.vishquebrou.model.dao.AbstractDAO;
import br.com.vishquebrou.util.*;

public class AbstractService<PK, T> {
	
	protected AbstractDAO<PK, T> dao;
	
	public void save(T entity){
        try{
            JPAUtil.beginTransaction();            
            dao.save(entity);
            JPAUtil.commit();
        }
        catch(Exception e){            
            JPAUtil.rollBack();
        }
        finally{
			JPAUtil.closeEntityManager();
		}
    }
	
	public void delete(T entity){
        try{
            JPAUtil.beginTransaction();            
            dao.delete(entity);;
            JPAUtil.commit();
        }
        catch(Exception e){            
            JPAUtil.rollBack();
        }
        finally{
			JPAUtil.closeEntityManager();
		}
    }
	
	public void update(T entity){
        try{
            JPAUtil.beginTransaction();            
            dao.update(entity);
            JPAUtil.commit();
        }
        catch(Exception e){            
            JPAUtil.rollBack();
        }
        finally{
			JPAUtil.closeEntityManager();
		}
    }
	
	public T getById(PK pk){
		T entity = null;
		
		try{
            JPAUtil.beginTransaction();            
            entity = dao.getById(pk);
            JPAUtil.commit();
        }
        catch(Exception e){            
            JPAUtil.rollBack();
        }
        finally{
			JPAUtil.closeEntityManager();
		}
		
		return entity;
	}
	
	public T getByProperty(String propertyName, String propertyValue){
		T entity = null;		
		try{
            JPAUtil.beginTransaction();            
            entity = dao.getByProperty(propertyName, propertyValue);
            JPAUtil.commit();
        }
        catch(Exception e){            
            JPAUtil.rollBack();
            e.printStackTrace();
        }
        finally{
			JPAUtil.closeEntityManager();
		}			
		
		return entity;
	}
	
	public List<T> findAll(){
        return dao.findAll();
    }
	
	public List<T> findAllById(String propertyName,PK pk){
        return dao.findAllById(propertyName, pk);
    }
}