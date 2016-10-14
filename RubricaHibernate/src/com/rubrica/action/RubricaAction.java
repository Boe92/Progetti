package com.rubrica.action;

import com.rubrica.entita.Rubrica;
import com.rubrica.modelDao.RubricaDao;

public class RubricaAction {
	
	public void aggiungiRubrica(Rubrica r) {
		RubricaDao vd = new RubricaDao();
		
		vd._insert(r);
	}
	
}
