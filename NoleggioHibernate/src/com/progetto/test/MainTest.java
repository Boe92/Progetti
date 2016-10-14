package com.progetto.test;

import java.util.List;

import com.progetto.action.Servizio;
import com.progetto.entita.Macchina;
import com.progetto.entita.Persona;

public class MainTest {

	public static void main(String[] args) {
		Servizio s = new Servizio();
		
		Macchina m1 = new Macchina(1,"Alfa Romeo","BZ457MK");
		s.aggiungiM(m1);
		Macchina m2 = new Macchina(2,"Alfa Romeo","BZ457MK");
		s.aggiungiM(m2);
		Macchina m3 = new Macchina(3,"Alfa Romeo","BZ457MK");
		s.aggiungiM(m3);
		
		Persona p1 = new Persona(1,"Marco","Boemi","BMOMRC92B10L219E");
		s.aggiungiP(p1);
		Persona p2 = new Persona(1,"Luca","Alberto","BMOMRC92B10L219E");
		s.aggiungiP(p2);
		Persona p3 = new Persona(1,"MariaTeresa","GianFranco","BMOMRC92B10L219E");
		s.aggiungiP(p3);
		
		m1.addPersona(p1);
		m1.addPersona(p2);
		m1.addPersona(p3);
		
		p1.addMacchina(m1);
		p1.addMacchina(m2);
		p1.addMacchina(m3);
		
		p2.addMacchina(m1);
		p2.addMacchina(m2);
		p2.addMacchina(m3);
		
		p3.addMacchina(m1);
		p3.addMacchina(m2);
		p3.addMacchina(m3);
		
		s.assegnaPersonaMacchina(m1, p1);
		s.assegnaPersonaMacchina(m2, p1);
		s.assegnaPersonaMacchina(m3, p1);
		
		s.assegnaPersonaMacchina(m1, p2);
		s.assegnaPersonaMacchina(m2, p2);
		s.assegnaPersonaMacchina(m3, p2);
		
		Persona pers = s.getPersona(8);
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
