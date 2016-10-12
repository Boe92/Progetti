package com.progetto.test;

import com.progetto.action.Servizio;
import com.progetto.entita.Macchina;
import com.progetto.entita.Persona;

public class MainTest {

	public static void main(String[] args) {
		Servizio s = new Servizio();
		
		Macchina m = s.aggiungiM("Alfa Romeo","BZ457MK");
		Macchina m2 = s.aggiungiM("Golf","BZ457MK");
		Macchina m3 = s.aggiungiM("Bmw serie 1","BZ457MK");
		
		Persona p = s.aggiungiP("Marco","Boemi","BMOMRC92B10L219E");
		
		s.assegnaPersonaMacchina(m, p);
		s.assegnaPersonaMacchina(m2, p);
		s.assegnaPersonaMacchina(m3, p);
		
		s.getTuttePersone();
		
		s.getTutteMacchinePerPersona(21);
	}
}
