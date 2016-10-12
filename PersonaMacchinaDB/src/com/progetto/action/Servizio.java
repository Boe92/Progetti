package com.progetto.action;

import java.util.List;

import com.progetto.dao.MacchinaDao;
import com.progetto.dao.MacchinaPersonaDao;
import com.progetto.dao.PersonaDao;
import com.progetto.entita.Macchina;
import com.progetto.entita.Persona;

public class Servizio {
	public Macchina aggiungiM(String modello, String targa) {
		MacchinaDao md = new MacchinaDao();
		Macchina m = md._insert(modello, targa);
		
		return m;
	}
	public Persona aggiungiP(String nome, String cognome, String CF) {
		PersonaDao pd = new PersonaDao();
		Persona p = pd._insert(nome, cognome, CF);
	
		return p;
	}
	
	public boolean assegnaPersonaMacchina(Macchina m, Persona p) {
		MacchinaPersonaDao pm = new MacchinaPersonaDao();
		boolean res = pm._insert(m, p);
		
		return res;
	}
	
	public List<Macchina> getTutteMacchinePerPersona(int id_persona) {
		MacchinaPersonaDao pm = new MacchinaPersonaDao();
		List<Macchina> lista = pm.getTutteMacchinePerPersona(id_persona);
		
		return lista;
	}
	
	public List<Persona> getTuttePersone() {
		PersonaDao p = new PersonaDao();
		List<Persona> lista = p._selectAll();
		
		return lista;
	}
}
