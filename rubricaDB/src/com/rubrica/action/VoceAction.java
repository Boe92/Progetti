package com.rubrica.action;

import java.util.List;

import com.rubrica.entita.Voce;
import com.rubrica.modelDao.VoceDao;

public class VoceAction {
	VoceDao vd = new VoceDao();
	
	//aggiunge una voce in rubrica
	public void aggiungiVoce(String nome, String cognome, String telefono, int id) {
		vd._insert(nome, cognome, telefono, id);
	}
	
	//aggiorna una singola voce
	public void aggiornaVoce (String nome, String cognome, String telefono, int id_voce) {
		vd._update(nome, cognome, telefono, id_voce);
	}
	
	//cancella una singola voce
	public void cancellaVoce (int id_voce) {
		vd._delete(id_voce);
	}
	
	//restituisce una singola voce
	public Voce getVoce(int id_voce) {
		Voce v = vd._select(id_voce);
		
		return v;
	}
	
	//restituisce una lista di voci
	public List<Voce> getTutteVoci(){
		List<Voce> voci = vd._selectAll();
		
		return voci;
	}
}