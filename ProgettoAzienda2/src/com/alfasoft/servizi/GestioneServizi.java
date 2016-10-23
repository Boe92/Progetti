package com.alfasoft.servizi;

import com.alfasoft.dao.AdminDao;
import com.alfasoft.dao.ClienteDao;
import com.alfasoft.dao.DipendenteDao;
import com.alfasoft.dao.RubricaDao;
import com.alfasoft.dao.VoceDao;
import com.alfasoft.entita.Cliente;
import com.alfasoft.entita.Dipendente;
import com.alfasoft.entita.Rubrica;
import com.alfasoft.entita.Utente;
import com.alfasoft.entita.Voce;
import com.alfasoft.util.CodificationOfPassword;

public class GestioneServizi {
	
	public Utente login(String username, String password) {
		AdminDao ad = new AdminDao();
		
    	Utente u = ad._select(username);
    	
    	String pwd = convertiPass(password);
    	if(u.getPassword().equals(pwd)) {
    		return u;
    	}else {
    		return null;
    	}
	}
	
	public boolean registraCliente(String nome, String username, String password, String partitaIva, String rubrica) {
		AdminDao ad = new AdminDao();
		RubricaDao rd = new RubricaDao();
		
		Rubrica r = new Rubrica();
		r.setNome(rubrica);
		
		Utente u = new Cliente();
		u.setNome(nome);
		u.setUsername(username);
		u.setRuolo('C');
		((Cliente)u).setPI(partitaIva);
		((Cliente)u).setRubrica(r);
		
    	rd._insert(r);
    	
    	
		String pwd = convertiPass(password);
		u.setPassword(pwd);
		
    	u = ad._insert(u);
    	if(u != null) {
    		return true;
    	}else {
    		return false;
    	}
    	
	}
	
	public boolean registraDipendente(String nome, String cognome, String username, String password, String stipendio, String rubrica) {
		AdminDao ad = new AdminDao();
		RubricaDao rd = new RubricaDao();
		
		Rubrica r = new Rubrica();
		r.setNome(rubrica);
		
		Utente u = new Dipendente();
		u.setNome(nome);
		u.setCognome(cognome);
		u.setUsername(username);
		u.setRuolo('D');
		((Dipendente)u).setStipendio(stipendio);
		((Dipendente)u).setRubrica(r);
		
    	rd._insert(r);
		
		
		String pwd = convertiPass(password);
		u.setPassword(pwd);
		
    	u = ad._insert(u);
    	
    	if(u != null) {
    		return true;
    	}else {
    		return false;
    	}
    	
	}
	
	public boolean aggiungiVoce(String nome, String cognome, String telefono, int idRubrica) {
		VoceDao vd = new VoceDao();
		RubricaDao rd = new RubricaDao();
		
		Voce v = new Voce();
		v.setNome(nome);
		v.setCognome(cognome);
		v.setTelefono(telefono);
		
		Rubrica r = rd._select(idRubrica);
		v.setRubrica(r);
		
		boolean res = vd._insert(v);
		
		return res;
	}
	
	public Cliente getIdRubricaCliente(int id_utente) {
		ClienteDao cd = new ClienteDao();
		
		Cliente c = cd._select(id_utente);
    	
    	return c;
	}
	
	public Dipendente getIdRubricaDipendente(int id_utente) {
		DipendenteDao cd = new DipendenteDao();
		
		Dipendente d = cd._select(id_utente);
    	
    	return d;
	}
	
	public Dipendente recuperoDipendente(int id_utente) {
		DipendenteDao dd = new DipendenteDao();
		
		Dipendente d = dd._select(id_utente);
    	
    	return d;
	}
	
	
	public String convertiPass(String pass){
		
		return CodificationOfPassword.codificatePass(pass);
	}

}
