package com.alfasoft.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alfasoft.entita.Cliente;
import com.alfasoft.entita.Voce;
import com.alfasoft.util.HibernateUtil;

public class ClienteDao {
	@SuppressWarnings("unchecked")
	public List<Cliente> _selectAll() {
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		List<Cliente> listaClienti = null;
		try{
			tx=session.getTransaction();
			tx.begin();
			
			listaClienti = session.createQuery("from Utente where ruolo = 'C'").list();	
			
			tx.commit(); 
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return listaClienti;
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
	
	
	public Cliente _select(int id_utente) {
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		Cliente cliente = null;
		try{
			tx=session.getTransaction();
			tx.begin();
			
			Query query = (Query) session.createQuery("from Cliente where id_utente = :campo1"); 
			query.setInteger("campo1", id_utente);
			
			cliente = (Cliente) query.uniqueResult();
			
			tx.commit(); 
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return cliente;
	}
}
