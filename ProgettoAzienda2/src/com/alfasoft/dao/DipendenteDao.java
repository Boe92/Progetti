package com.alfasoft.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alfasoft.entita.Dipendente;
import com.alfasoft.entita.Voce;
import com.alfasoft.util.HibernateUtil;

public class DipendenteDao {
	@SuppressWarnings("unchecked")
	public List<Dipendente> _selectAll() {
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		List<Dipendente> listaDipendenti = null;
		try{
			tx=session.getTransaction();
			tx.begin();
			
			listaDipendenti = session.createQuery("from Utente where ruolo = 'D'").list();	
			
			tx.commit(); 
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return listaDipendenti;
	}
	
	public Dipendente _select(int id_utente) {
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		Dipendente dipendente = null;
		try{
			tx=session.getTransaction();
			tx.begin();
			
			Query query = (Query) session.createQuery("from Dipendente where id_utente = :campo1"); 
			query.setInteger("campo1", id_utente);
			
			dipendente = (Dipendente) query.uniqueResult();
			
			tx.commit(); 
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return dipendente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Voce> _getTutteVoci(int idRubrica) {
		System.out.println("_getTutteVoci "+idRubrica);
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		List<Voce> listaVoci = null;
		try{
			tx=session.getTransaction();
			tx.begin();
			
			//listaClienti = session.createQuery("from Cliente c, Voce v where c.rubrica_id_rubrica = :campo1  and v.rubrica_id_rubrica = c.rubrica_id_rubrica").list();	
			Query query = (Query) session.createQuery("from Voce where rubrica_id_rubrica = :campo1 "); 
			query.setInteger("campo1", idRubrica);
			
			listaVoci = (List<Voce>) query.list();
			
			tx.commit(); 
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return listaVoci;
	}
}
