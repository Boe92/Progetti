package com.rubrica.action;

import com.rubrica.modelDao.RubricaDao;

public class RubricaAction {
	//aggiunge una voce in rubrica
	public int aggiungiRubrica(String nome) {
		RubricaDao rd = new RubricaDao();
		
		int id = rd._insert(nome);
		return id;
	}

}
