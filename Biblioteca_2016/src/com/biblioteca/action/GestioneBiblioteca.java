package com.biblioteca.action;

import java.util.List;

import com.biblioteca.entita.Biblioteca;
import com.biblioteca.entita.Libro;
import com.biblioteca.entita.Prestito;
import com.biblioteca.entita.Utente;

public class GestioneBiblioteca {

	
	public void registraLibro(Biblioteca b, String autore, String titolo, int cp) {	
		Libro libro = null;
		List<Libro> libri = b.getListaLibri();
		
		if (libri.size() > 0) {
			for(Libro l1: libri){
				if(autore.equals(l1.getAutore()) && titolo.equals(l1.getTitolo())) {
					//l1.setCopieTotali(l1.getCopieTotali() + cp);
					//l1.setCopieDisponibili(l1.getCopieDisponibili() + cp);
					break;
				}else {
					libro = new Libro(autore, titolo);
					
					b.aggiungiLibro(libro);
					
					System.out.print("registraLibro: " + libro.getAutore()+" "+ libro.getTitolo());
					
					libro.setCopieTotali(cp);
					libro.setCopieDisponibili(cp);
					break;
				}
			}
		}else {
			libro = new Libro(autore, titolo);
			
			b.aggiungiLibro(libro);
			
			libro.setCopieTotali(cp);
			libro.setCopieDisponibili(cp);
			
			System.out.println("registraLibro: " + libro.getAutore() +" "+ libro.getTitolo() +" "+ libro.getCopieTotali());
		}
	}
	
	
	public void registraUtente(Biblioteca b,String nome, String cognome) {
		Utente utente = null;
		List<Utente> listaUtenti = b.getListaUtenti();
		
		if (listaUtenti.size() > 0) {
			for(Utente u : listaUtenti) {
				if (nome.equals(u.getNome()) && cognome.equals(u.getCognome())){
					System.out.println("Utente gia esistente");
				}else {
					utente = new Utente(nome, cognome);
					b.aggiungiUtente(utente);
					
					System.out.println(utente.getNome() + utente.getCognome());
				}
			}
		}else {
			utente = new Utente(nome, cognome);
			b.aggiungiUtente(utente);
			
			System.out.println(utente.getNome() + utente.getCognome());
		}
	}
	
	public boolean prestaLibro(Biblioteca b, String titolo, String autore, String nome, String cognome) {
		
		boolean res = false;
		
		Utente utente = null;
		Libro libro = null;
		
		for (Utente u : b.getListaUtenti()) {
			if (u.getNome().equals(nome) && u.getCognome().equals(cognome)) {
				utente = u;
			}
		}

		for (Libro l : b.getListaLibri()) {
			if (l.getAutore().equals(autore) && l.getTitolo().equals(titolo)) {
				libro = l;
			}
		}
		
		if(libro.getCopieDisponibili() > 0) {
			if(utente.getNumeroPrestiti() < 3) {
				
				Prestito p = new Prestito(libro, utente);
				b.getListaPrestiti().add(p);
				utente.setNumeroPrestiti(utente.getNumeroPrestiti() + 1);
				libro.setCopieDisponibili(libro.getCopieDisponibili() - 1);
				
				res = true;
				
				//verifica
				System.out.println(libro.getCopieDisponibili());
				System.out.println(utente.getNumeroPrestiti());
			}
		}
		
		return res;
	}
	
	public boolean restituisciLibro (Biblioteca b, String titolo, String autore, String nome, String cognome){
		
		boolean res = false;
		
		Utente utente = null;
		Libro libro = null;
		Prestito prestito = null;

		for (Utente u : b.getListaUtenti()) {
			if (u.getNome().equals(nome) && u.getCognome().equals(cognome)) {
				utente = u;
			}
		}
		
		for (Libro l : b.getListaLibri()) {
			if (l.getAutore().equals(autore) && l.getTitolo().equals(titolo)) {
				libro = l;
			}
		}
		
		for (Prestito p : b.getListaPrestiti()) {
			
			String nome2 = p.getUtente().getNome();
			String cognome2 = p.getUtente().getCognome();
			
			if (nome2.equals(utente.getNome()) && cognome2.equals(utente.getCognome())) {
				String autore2 = p.getLibro().getAutore();
				String titolo2 = p.getLibro().getTitolo();
				
				if (autore2.equals(libro.getAutore()) && titolo2.equals(libro.getTitolo())) {
					prestito = p;
				}
			}
		}
		
		if(prestito!=null){
			//restituisco libro
			b.getListaPrestiti().remove(prestito);
			
			res = true;
		}
		
		
		return res;
	}
	
}
