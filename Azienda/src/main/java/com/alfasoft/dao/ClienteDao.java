package com.alfasoft.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alfasoft.entita.Cliente;
import com.alfasoft.entita.Utente;
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
	
	@SuppressWarnings("unchecked")
	public List<Voce> _getTutteVoci(String nome, String cognome, int idRubrica) {
		System.out.println("_getTutteVoci "+idRubrica);
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		List<Voce> listaVoci = null;
		try{
			tx=session.getTransaction();
			tx.begin();
			
			//listaClienti = session.createQuery("from Cliente c, Voce v where c.rubrica_id_rubrica = :campo1  and v.rubrica_id_rubrica = c.rubrica_id_rubrica").list();	
			Query query = (Query) session.createQuery("from Voce where nome = :campo1 and cognome = :campo2 and rubrica_id_rubrica = :campo3 "); 
			query.setString("campo1", nome);
			query.setString("campo2", cognome);
			query.setInteger("campo3", idRubrica);
			
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
	
	public void _delete(int id_utente) {
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		try{
			tx=session.getTransaction();
			tx.begin();
			
			Query query = (Query)session.createQuery("delete from Utente where id_utente = :campo1"); 
			query.setInteger("campo1", id_utente);
			
			query.executeUpdate();
			tx.commit(); 
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	
	public boolean _update(Utente u) {
		System.out.println("update cliente");
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		boolean res = false;
		try{
			tx=session.getTransaction();
			tx.begin();
			
//			Query query = session.createQuery("update Utente set nome = :campo1, cognome = :campo2, username = :campo3, ruolo = :campo4, password = :campo5, pi = :campo6 where id_utente = :campo7"); 
//			query.setString("campo1", u.getNome());
//			query.setString("campo2", u.getCognome());
//			query.setString("campo3", u.getUsername());
//			query.setCharacter("campo4", u.getRuolo());
//			query.setString("campo5", u.getPassword());
//			query.setString("campo6", ((Cliente)u).getPI());
//			query.setInteger("campo7", u.getId_utente());
			session.update(u);
			//int row = query.executeUpdate();
			
			tx.commit();
			
			//System.out.println("righe aggiornate: " + row);
			res = true;
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return res;
	}
}
