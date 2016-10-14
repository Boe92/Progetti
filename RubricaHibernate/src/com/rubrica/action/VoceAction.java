package com.rubrica.action;

import java.util.List;

import com.rubrica.entita.Voce;
import com.rubrica.modelDao.VoceDao;

public class VoceAction {
	
	//aggiunge una voce in rubrica
	public void aggiungiVoce(Voce v) {
		VoceDao vd = new VoceDao();
		
		vd._insert(v);
	}
	
	//aggiorna una singola voce
	public void aggiornaVoce (String nome, String cognome, String telefono, int id_voce) {
		
	}
	
	//cancella una singola voce
	public void cancellaVoce (int id_voce) {
		
	}
	
	//restituisce una singola voce
	public Voce getVoce(int id_voce) {
		return null;
	}
	
	//restituisce una lista di voci
	public List<Voce> getTutteVoci(){
		return null;
	}
}
