package com.alfasoft.dao;

import java.util.List;

import org.hibernate.Query;
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
	
	@SuppressWarnings("unchecked")
	public List<Voce> _select(int id_rubrica, String nome, String cognome) {
		System.out.println("entrato");
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		List<Voce> voci = null;
		try{
			tx=session.getTransaction();
			tx.begin();
			
			Query query = (Query) session.createQuery("from Voce where rubrica_id_rubrica = :campo1 and nome = :campo2 and cognome = :campo3"); 
			query.setInteger("campo1", id_rubrica);
			query.setString("campo2", nome);
			query.setString("campo3", cognome);
			
			voci = (List<Voce>) query.list();
			
			tx.commit(); 
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return voci;
	}
}
