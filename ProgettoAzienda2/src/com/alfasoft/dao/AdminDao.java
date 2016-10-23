package com.alfasoft.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alfasoft.entita.Utente;
import com.alfasoft.util.HibernateUtil;

public class AdminDao {
	
	public Utente _select(String username) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		Utente u = null;
		try{
			tx=session.getTransaction();
			tx.begin();
			
			Query query = (Query) session.createQuery("from Utente where username = :campo1"); 
			query.setString("campo1", username);
			
			u = (Utente) query.uniqueResult();
			
			tx.commit(); 
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return u;
	}
	
	public Utente _insert(Utente u) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		try{
			tx=session.getTransaction();
			tx.begin();
			
			session.persist(u);
			
			tx.commit(); 
		}catch(Exception ex){
			tx.rollback();
			u = null;
		}finally{
			session.close();
		}
		
		return u;
	}
}
