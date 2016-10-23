package com.alfasoft.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alfasoft.entita.Rubrica;
import com.alfasoft.util.HibernateUtil;

public class RubricaDao {
	public Rubrica _select(int idRubrica) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		Rubrica r = null;
		try{
			tx=session.getTransaction();
			tx.begin();
			
			Query query = (Query) session.createQuery("from Rubrica where id_rubrica = :campo1"); 
			query.setInteger("campo1", idRubrica);
			
			r = (Rubrica) query.uniqueResult();
			
			tx.commit(); 
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return r;
	}
	
	public boolean _insert(Rubrica r) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		boolean res = false;
		try{
			tx=session.getTransaction();
			tx.begin();
			
			session.persist(r);
			
			tx.commit(); 
			
			res = true;
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return res;
	}
}
