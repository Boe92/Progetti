package com.rubrica.mainTest;

import com.rubrica.action.RubricaAction;
import com.rubrica.action.VoceAction;

public class MainTest {

	public static void main(String[] args) {
		RubricaAction ra = new RubricaAction();
		VoceAction va = new VoceAction();
		
		//inserisco rubrica
		String nomeRubrica = "DelPiero_Rubrica";
		int id = ra.aggiungiRubrica(nomeRubrica);
		
		//inserisco voce
		String nomeVoce = "Armando";
		String cognomeVoce = "Boemi";
		String telefonoVoce = "3496451512";
		va.aggiungiVoce(nomeVoce, cognomeVoce, telefonoVoce, id);
		
		//inserisco voce 2
		nomeVoce = "Calogero";
		cognomeVoce = "Boemi";
		telefonoVoce = "3496451512";
		va.aggiungiVoce(nomeVoce, cognomeVoce, telefonoVoce, id);
		
		//inserisco voce 3
		nomeVoce = "Ernesto";
		cognomeVoce = "Boemi";
		telefonoVoce = "3496451512";
		va.aggiungiVoce(nomeVoce, cognomeVoce, telefonoVoce, id);
		
		//cancellaVoce
		va.cancellaVoce(61);
		
		//modificaVoce
		va.aggiornaVoce("Giancarlo", "Rovazzi", "333333333", 67);
		
		//listaVociDB
		va.getVoce(28);
				
		//listaVociDB
		va.getTutteVoci();
	}
}
