package com.alfasoft.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alfasoft.entita.BustaPaga;
import com.alfasoft.util.HibernateUtil;

public class BustaPagaDao {
	
	@SuppressWarnings("unchecked")
	public List<BustaPaga> _selectAll() {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		List<BustaPaga> listaBuste = null;
		try{
			tx=session.getTransaction();
			tx.begin();
			
			listaBuste = session.createQuery("from BustaPaga").list();	
			
			tx.commit(); 
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return listaBuste;
	}
	
	@SuppressWarnings("unchecked")
	public List<BustaPaga> _selectAll(int id_utente) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		List<BustaPaga> listaBuste = null;
		try{
			tx=session.getTransaction();
			tx.begin();
			
			Query query = (Query) session.createQuery("from BustaPaga where dipendente_id_utente = :campo1");	
			query.setInteger("campo1", id_utente);
			
			listaBuste = (List<BustaPaga>) query.list();
			
			tx.commit(); 
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return listaBuste;
	}
	
	public boolean _insert(BustaPaga b) {
		System.out.println("insert Busta paga");
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		boolean res = false;
		try{
			tx=session.getTransaction();
			tx.begin();
			
			session.persist(b);
			
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
