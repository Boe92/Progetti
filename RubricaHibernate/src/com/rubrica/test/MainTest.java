package com.rubrica.test;

import com.rubrica.action.RubricaAction;
import com.rubrica.action.VoceAction;
import com.rubrica.entita.Rubrica;
import com.rubrica.entita.Voce;

public class MainTest {

	public static void main(String[] args) {
		Rubrica r = new Rubrica();
		VoceAction va = new VoceAction();
		RubricaAction ra = new RubricaAction();
		
		Voce v1 = new Voce(1,"Graziella","Boemi","3496451512");
		Voce v2 = new Voce(2,"Alberto","Boemi","3496451512");
		Voce v3 = new Voce(3,"GianMario","Boemi","3496451512");
		
		r.setNome("LucaRubrica");
		v1.setRubrica(r);
		v2.setRubrica(r);
		v3.setRubrica(r);
		
		ra.aggiungiRubrica(r);
		
		r.addVoce(v1);
		r.addVoce(v2);
		r.addVoce(v3);

		va.aggiungiVoce(v1);
		va.aggiungiVoce(v2);
		va.aggiungiVoce(v3);	
	}
}
