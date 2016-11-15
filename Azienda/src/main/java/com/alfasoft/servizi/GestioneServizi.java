package com.alfasoft.servizi;

import java.util.Date;

import com.alfasoft.dao.AdminDao;
import com.alfasoft.dao.BustaPagaDao;
import com.alfasoft.dao.ClienteDao;
import com.alfasoft.dao.DipendenteDao;
import com.alfasoft.dao.RubricaDao;
import com.alfasoft.dao.VoceDao;
import com.alfasoft.entita.BustaPaga;
import com.alfasoft.entita.Cliente;
import com.alfasoft.entita.Dipendente;
import com.alfasoft.entita.Rubrica;
import com.alfasoft.entita.Utente;
import com.alfasoft.entita.Voce;
import com.alfasoft.util.CodificationOfPassword;

public class GestioneServizi {
	
	AdminDao ad = new AdminDao();
	RubricaDao rd = new RubricaDao();
	VoceDao vd = new VoceDao();
	ClienteDao cd = new ClienteDao();
	DipendenteDao dd = new DipendenteDao();
	
	
	public Utente login(String username, String password) {
		Utente u = ad._select(username);
    	
    	String pwd = convertiPass(password);
    	if(u!=null && u.getPassword().equals(pwd)) {
    		return u;
    	}else {
    		return null;
    	}
	}
	
	public boolean registraCliente(String nome, String username, String password, String partitaIva, String rubrica) {
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
	
	public boolean registraBustaPaga(String importo, Date data, int id_utente) {
		System.out.println("registraBustaPaga");
		BustaPagaDao bd = new BustaPagaDao();
		
		BustaPaga bp = new BustaPaga();
		bp.setImporto(importo);
		bp.setData_emissione(data);
		
		Dipendente d = dd._select(id_utente);
		bp.setDipendente(d);
		
		boolean res = bd._insert(bp);
		if(res) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean aggiungiVoce(String nome, String cognome, String telefono, int idRubrica) {
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
		Cliente c = cd._select(id_utente);
    	
    	return c;
	}
	
	public Dipendente getIdRubricaDipendente(int id_utente) {
		Dipendente d = dd._select(id_utente);
    	
    	return d;
	}
	
	public Dipendente recuperoDipendente(int id_utente) {
		Dipendente d = dd._select(id_utente);
    	
    	return d;
	}
	
	public void eliminaDipendente(int id_utente) {
		dd._delete(id_utente);
	}
	
	public void eliminaCliente(int id_utente) {
		dd._delete(id_utente);
	}
	
	public String trovaRuolo(int id_utente) {
		Utente u  = ad._select(id_utente);
		
		if(u.getRuolo()=='A') {
			return "Admin";
		}else if(u.getRuolo()=='C') {
			return "Cliente";
		}else {
			return "Dipendente";
		}
		
	}
	
	public boolean isAdmin(int id_utente) {
		Utente u  = ad._select(id_utente);
		
		if(u.getRuolo()=='A') {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean isDipendente(int id_utente) {
		Utente u  = ad._select(id_utente);
		
		if(u.getRuolo()=='D') {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isCliente(int id_utente) {
		Utente u  = ad._select(id_utente);
		
		if(u.getRuolo()=='C') {
			return true;
		}else {
			return false;
		}
	}
	
	public String convertiPass(String pass){
		
		return CodificationOfPassword.codificatePass(pass);
	}

}
