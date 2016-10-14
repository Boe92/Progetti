package com.progetto.test;

import java.util.List;

import com.progetto.action.Servizio;
import com.progetto.entita.Macchina;
import com.progetto.entita.Persona;

public class MainTest {

	public static void main(String[] args) {
		Servizio s = new Servizio();
		
		Macchina m1 = new Macchina(1,"Alfa Romeo 1","BZ457MK");
		s.aggiungiM(m1);
		Macchina m2 = new Macchina(2,"Alfa Romeo 2","BZ457MK");
		s.aggiungiM(m2);
		Macchina m3 = new Macchina(3,"Alfa Romeo 3","BZ457MK");
		s.aggiungiM(m3);
		
		Macchina m4 = new Macchina(1,"Ferrari 1","BZ457MK");
		s.aggiungiM(m4);
		Macchina m5 = new Macchina(2,"Ferrari 2","BZ457MK");
		s.aggiungiM(m5);
		Macchina m6 = new Macchina(3,"Ferrari 3","BZ457MK");
		s.aggiungiM(m6);
		
		Macchina m7 = new Macchina(1,"Golf 1","BZ457MK");
		s.aggiungiM(m7);
		Macchina m8 = new Macchina(2,"Golf 2","BZ457MK");
		s.aggiungiM(m8);
		Macchina m9 = new Macchina(3,"Golf 3","BZ457MK");
		s.aggiungiM(m9);
		
		Persona p1 = new Persona(1,"Marco","Boemi","BMOMRC92B10L219E");
		s.aggiungiP(p1);
		Persona p2 = new Persona(1,"Luca","Alberto","BMOMRC92B10L219E");
		s.aggiungiP(p2);
		Persona p3 = new Persona(1,"MariaTeresa","GianFranco","BMOMRC92B10L219E");
		s.aggiungiP(p3);
		
		m1.addPersona(p1);
		m2.addPersona(p1);
		m3.addPersona(p1);

		m4.addPersona(p2);
		m5.addPersona(p2);
		m6.addPersona(p2);
		
		p1.addMacchina(m1);
		p1.addMacchina(m2);
		p1.addMacchina(m3);
		
		p2.addMacchina(m4);
		p2.addMacchina(m5);
		p2.addMacchina(m6);
		
//		p3.addMacchina(m7);
//		p3.addMacchina(m8);
//		p3.addMacchina(m9);
		
		s.assegnaPersonaMacchina(m1, p1);
		s.assegnaPersonaMacchina(m2, p1);
		s.assegnaPersonaMacchina(m3, p1);
		
		s.assegnaPersonaMacchina(m4, p2);
		s.assegnaPersonaMacchina(m5, p2);
		s.assegnaPersonaMacchina(m6, p2);
		
//		s.assegnaPersonaMacchina(m7, p3);
//		s.assegnaPersonaMacchina(m8, p3);
//		s.assegnaPersonaMacchina(m9, p3);
		
		Persona pers = s.getPersona(3);
		System.out.println(pers.getId_persona()+" "+pers.getNome()+" "+pers.getCognome()+" "+pers.getCF());
		
		
		
		//getTutteMacchinePerPersona
		for(Macchina m: pers.getMacchina()){
			System.out.println(m.getModello()+" "+m.getTarga());
		}
		
		
		List<Persona> listaPersone = s.getTuttePersone();
		for(Persona p:listaPersone) {
			System.out.println(p.getId_persona()+" "+p.getNome()+" "+p.getCognome()+" "+p.getCF());
		}

	}
}
