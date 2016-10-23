package com.alfasoft.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alfasoft.entita.Voce;
import com.alfasoft.util.HibernateUtil;

public class VoceDao {
	public boolean _insert(Voce v) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		boolean res = false;
		try{
			tx=session.getTransaction();
			tx.begin();
			
			session.persist(v);
			
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
