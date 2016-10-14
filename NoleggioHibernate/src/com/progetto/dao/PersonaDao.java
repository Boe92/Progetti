package com.progetto.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.progetto.entita.Persona;
import com.progetto.util.HibernateUtil;

public class PersonaDao {
	
	public Persona _select(int id_persona) {
		
		Persona p = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		try{
			tx=session.getTransaction();
			tx.begin();
			
			Query query = (Query) session.createQuery("from Persona where id_persona = :campo1"); 
			query.setInteger("campo1", id_persona);
			
			p = (Persona) query.uniqueResult();
			
			tx.commit(); 
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return p;
	}
	

	@SuppressWarnings("unchecked")
	public List<Persona> _selectAll() {
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		List<Persona> listaPersona = null;
		try{
			tx=session.getTransaction();
			tx.begin();
			
			Query query = (Query) session.createQuery("from Persona"); 
			listaPersona = (List<Persona>)query.list();	
			
			tx.commit(); 
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return listaPersona;
	}
	
	public Persona _insert(Persona p) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		try{
			tx=session.getTransaction();
			tx.begin();
			
			session.save(p);
			
			tx.commit(); 
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return p;
	}
	
	public int getLastInsertIdPersona() {
		int id = 0;
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
		
		return id;
	}
	
	public boolean _update(String nome, String cognome, String CF, int id_persona) {
		
		boolean res = false;
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
		
		return res;
	}
	
	public boolean _delete(int id_persona) {
		
		boolean res = false;
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
		
		return res;
	}
}
