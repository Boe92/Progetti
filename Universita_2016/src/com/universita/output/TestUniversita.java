package com.universita.output;

import com.universita.action.Segreteria;
import com.universita.entita.Corso;
import com.universita.entita.Docente;
import com.universita.entita.Studente;
import com.universita.entita.Universita;

public class TestUniversita {

	public static void main(String[] args) {
		Segreteria s = new Segreteria();
		Universita u = new Universita("Politecnico Torino");
		
		Studente stud = s.registraStudente(u, "Marco", "Boemi");
		Studente stud2 = s.registraStudente(u, "Morot", "alfa");
		
		Docente d = s.registraDocente(u, "Gabbiani", "alfa", "GBNLFA92B10L219E");
		Docente d2 = s.registraDocente(u, "Gabbiani", "Beta", "GBNBTA92B10L219E");
		
		Corso corso = s.registraCorso(u, "Informatica", 320);
		Corso corso2 = s.registraCorso(u, "Chimica", 320);
		
		System.out.println("aggiungiStudentialCorso: " +s.aggiungiStudentialCorso(u, stud, corso));
		System.out.println("aggiungiStudentialCorso: " +s.aggiungiStudentialCorso(u, stud, corso));
		
		System.out.println("aggiungiDocentealCorso: " +s.aggiungiDocentealCorso(u, d, corso));
		System.out.println("aggiungiDocentealCorso: " +s.aggiungiDocentealCorso(u, d2, corso));
	}

}
