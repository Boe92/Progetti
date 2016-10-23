package com.alfasoft.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alfasoft.entita.Admin;
import com.alfasoft.entita.Utente;
import com.alfasoft.util.HibernateUtil;

public class MainTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		Utente u = new Admin();
		u.setNome("Marco");
		u.setCognome("Boemi");
		u.setUsername("dregon");
		u.setPassword("dregon");
		u.setRuolo('A');
		((Admin)u).setLivelloAccesso("alto");
		
		try{
			tx=session.getTransaction();
			tx.begin();
			
			session.persist(u);
			
			tx.commit(); 
		}catch(Exception ex){
			tx.rollback();
			
		}finally{
			session.close();
		}

	}

}
