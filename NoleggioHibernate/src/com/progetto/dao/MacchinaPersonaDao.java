package com.progetto.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.progetto.entita.Macchina;
import com.progetto.entita.Persona;
import com.progetto.util.HibernateUtil;

public class MacchinaPersonaDao {
	
	public boolean _insert(Macchina m, Persona p) {
		boolean res = false;
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		try{
			tx=session.getTransaction();
			tx.begin();
			
			session.save(m);
			
			tx.commit(); 
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		
		return res;
	}
	
	public List<Macchina> getTutteMacchinePerPersona(int id_persona) {
		List<Macchina> listaMacchine = new ArrayList<Macchina>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		try{
			tx=session.getTransaction();
			tx.begin();
			
			
			
			tx.commit(); 
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		
		return listaMacchine;
	}
}
