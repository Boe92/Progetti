package com.rubrica.modelDao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rubrica.entita.Rubrica;
import com.rubrica.util.HibernateUtil;

public class RubricaDao {
	
	public void _insert(Rubrica r) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		try{
			tx=session.getTransaction();
			tx.begin();
			
			session.save(r);
			
			tx.commit(); 
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
	}
}
