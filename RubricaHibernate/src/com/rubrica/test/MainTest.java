package com.rubrica.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rubrica.entita.Rubrica;
import com.rubrica.entita.Voce;
import com.rubrica.util.HibernateUtil;

public class MainTest {

	public static void main(String[] args) {
		Rubrica r = new Rubrica();
		Voce v1 = new Voce(1,"Marco","Boemi","3496451512");
		Voce v2 = new Voce(1,"Gianni","Roselli","3496499912");
		Voce v3 = new Voce(1,"Lucrezia","Alfieri","3448901512");
		
		r.setNome("MarcoRubrica");
		
		r.addVoce(v1);
		r.addVoce(v2);
		r.addVoce(v3);
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		try{
			tx=session.getTransaction();
			tx.begin();
			
			session.save(r);
			session.save(v1);
			session.save(v2);
			session.save(v3);
			
			tx.commit(); 
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
	}
}
