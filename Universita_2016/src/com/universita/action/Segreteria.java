package com.universita.action;

import java.util.List;

import com.universita.entita.Corso;
import com.universita.entita.Docente;
import com.universita.entita.Studente;
import com.universita.entita.Universita;

public class Segreteria {
	
	public Studente registraStudente(Universita u, String nome, String cognome) {
		
		Studente studente = null;
		List<Studente> studenti = u.getListaStudenti();
		
		studente = new Studente(nome, cognome);
		if (studenti.size() > 0) {
			for (Studente s : studenti) {
				if (s.getNome().equals(nome) && s.getCognome().equals(cognome)) {
					System.out.println("Lo Studente " +studente.getNome() +" "+studente.getCognome()+ "gia registrato");
					break;
				}else {
					String matricola = u.generaMatricola(nome, cognome);
					studente.setMatricola(matricola);
		
					studenti.add(studente);
					
					System.out.println("registraStudente: "+studente.getNome() + " " + studente.getCognome() + " " + matricola);
					break;
				} 
			}
		}else {
			String matricola = u.generaMatricola(nome, cognome);
			studente.setMatricola(matricola);

			studenti.add(studente);
			
			System.out.println("registraStudente: "+studente.getNome() + " " + studente.getCognome() + " " + matricola);
		}
		
		return studente;
	}

	public Docente registraDocente(Universita u, String nome, String cognome, String codiceFiscale){
		
		Docente docente = null;
		
		List<Docente> docenti = u.getListaDocenti();
		
		if(docenti.size() > 0) {
			for (Docente d : docenti){
				if(d.getCodiceFiscale().equals(codiceFiscale)){
					System.out.println("Docente gia esistente");
					break;
				}else {
					docente= new Docente(nome,cognome,codiceFiscale);
					
					docenti.add(docente);
					
					System.out.println("registraDocente: "+docente.getNome()+" "+docente.getCognome() );
					break;
				}
			}
		}else {
			docente= new Docente(nome,cognome,codiceFiscale);
			
			docenti.add(docente);
			
			System.out.println("registraDocente: "+docente.getNome()+" "+docente.getCognome() );
		}
		return docente;
	}

	public Corso registraCorso(Universita u, String nome, int ore){
		
		Corso corso = null;
		
		List<Corso> corsi= u.getListaCorsi();
		
		if(corsi.size() > 0) {
			for (Corso c : corsi){
				if(c.getNome().equals(nome) && c.getOre()==ore){
					System.out.println("Corso gia registrato");
					break;
				}else {
					corso = new Corso(nome,ore);
					
					corsi.add(corso);
					
					System.out.println("registraCorso: "+corso.getNome()+" "+ corso.getOre());
					break;
				}
			}
		}else {
			corso = new Corso(nome,ore);
			
			corsi.add(corso);
			
			System.out.println("registraCorso: "+corso.getNome()+" "+ corso.getOre());
		}
		
		return corso;
	}

	public boolean aggiungiStudentialCorso(Universita u,Studente s, Corso c){
		
		boolean res = false;
		
		List<Studente> studentiCorso = c.getStudentiCorso();
		
		if(studentiCorso.size() > 0) {
			for (Studente s1 : studentiCorso) {
				if(!s1.getNome().equals(s.getNome()) && !s1.getCognome().equals(s.getCognome())){
					c.getStudentiCorso().add(s);
					res = true;
					break;
				}
			}
		}else {
			c.getStudentiCorso().add(s);
			res = true;
		}

		return res;
	}
	
	public boolean aggiungiDocentealCorso(Universita u,Docente d, Corso c){
		
		boolean res = false;
		
		List<Docente> docentiCorso = c.getDocentiCorso();
		
		if(docentiCorso.size() > 0) {
			for (Docente d1 : docentiCorso) {
				if(!d1.getNome().equals(d.getNome()) && !d1.getCognome().equals(d.getCognome()) && d1.getCodiceFiscale().equals(d.getCodiceFiscale())){
					c.getDocentiCorso().add(d);
					res = true;
					break;
				}
			}
		}else {
			c.getDocentiCorso().add(d);
			res = true;
		}

		return res;
	}
	
	
}
