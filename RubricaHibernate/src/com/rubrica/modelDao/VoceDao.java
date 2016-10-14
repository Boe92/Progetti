package com.rubrica.modelDao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rubrica.entita.Rubrica;
import com.rubrica.entita.Voce;
import com.rubrica.util.HibernateUtil;

public class VoceDao {
	
	public void _insert(Voce v) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		try{
			tx=session.getTransaction();
			tx.begin();
			
			session.save(v);
			
			tx.commit(); 
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	public Voce _select(int id_voce) {
		Voce v = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		try{
			tx=session.getTransaction();
			tx.begin();
			
			v = session.get(Voce.class, id_voce);
			
			tx.commit(); 
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return v;
	}
	
	public List<Voce> _selectAll() {
		Rubrica r = new Rubrica();
		
		List<Voce> listaVoci = new ArrayList<>();
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		try{
			tx=session.getTransaction();
			tx.begin();
			
			tx.commit();
			
			for (Voce v1: r.getVoci()) {
				System.out.print(v1.getNome()+" "+v1.getCognome()+" "+v1.getTelefono());
			}
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return listaVoci;
	}
	
	
	public void _update(String nome, String cognome, String telefono, int id_voce) {
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
	}
	
	public void _delete(int id_voce) {
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
	}
}
