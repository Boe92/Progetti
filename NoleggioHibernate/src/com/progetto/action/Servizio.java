package com.progetto.action;

import java.util.List;

import com.progetto.dao.MacchinaDao;
import com.progetto.dao.MacchinaPersonaDao;
import com.progetto.dao.PersonaDao;
import com.progetto.entita.Macchina;
import com.progetto.entita.Persona;

public class Servizio {
	public Macchina aggiungiM(Macchina m) {
		MacchinaDao md = new MacchinaDao();
		
		m = md._insert(m);
		
		return m;
	}
	public Persona aggiungiP(Persona p) {
		PersonaDao pd = new PersonaDao();
		p = pd._insert(p);
	
		return p;
	}
	
	public boolean assegnaPersonaMacchina(Macchina m, Persona p) {
		MacchinaPersonaDao pm = new MacchinaPersonaDao();
		boolean res = pm._insert(m, p);
		
		return res;
	}
	
	public List<Persona> getTuttePersone() {
		PersonaDao p = new PersonaDao();
		List<Persona> lista = p._selectAll();
		
		return lista;
	}
	
	public Persona getPersona(int id_persona) {
		PersonaDao pd = new PersonaDao();
		Persona p = pd._select(id_persona);
		
		return p;
		
	}
}
