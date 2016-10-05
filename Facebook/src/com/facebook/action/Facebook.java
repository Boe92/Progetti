package com.facebook.action;

import java.util.ArrayList;
import java.util.List;
import com.facebook.entity.Utente;

public class Facebook extends Utente {
	
	private  List<Utente> listaUtenti = new ArrayList<Utente>();
	
	//Costruttore default
	public Facebook() {}
	
	//validita email
	String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public void registraUtente(String nome, String cognome, Integer eta, char sesso, String email) {
		if(nome==null || nome.isEmpty()){
			System.out.println("nome obbligatorio! ");
		}else if (cognome==null || cognome.isEmpty()) {
			System.out.println("cognome obbligatorio! ");
		}else if (eta==null){
			System.out.println("eta obbligatoria! ");
		}else if (eta<=0 ){
			System.out.println("L'eta deve essere superiore a 0! ");
		}else if (sesso<=0 || eta==null){
			System.out.println("eta obbligatoria! ");
		}else if (email==null || email.isEmpty()) {
			System.out.println("email obbligatoria! ");
		}else if (!email.matches(emailPattern)) {
			System.out.println("email sbagliata! ");
		}else {
			Utente utente = new Utente(nome, cognome, eta, sesso, email);
			List<Utente> listaUtenti = getListaUtenti();
	
			//controllo se la lista e gia stata riempita
			if(listaUtenti.size() > 0) {
				boolean presente = false;
				
				for (Utente u : listaUtenti){
					if (u.getNome().equals(nome) && u.getCognome().equals(cognome) && u.getEta()==eta && u.getSesso()==sesso && u.getEmail().equals(email)){
						presente = true;
						break;
					}else {	
						presente = false;
					}
				}
				if (presente) {
					System.out.println("Utente gia registrato!");
				}else{
					listaUtenti.add(utente);
					System.out.println("Registrazione avvenuta!");
				}
			}else {//prima volta
				listaUtenti.add(utente);
				System.out.println("Registrazione avvenuta1!");
			}
		}
	}
	
	
	public void aggiungiAmici(String nomeCognome1, String nomeCognome2) {
		Utente utente = null;
		Utente amico = null;
		
		if(nomeCognome1==null || nomeCognome1.isEmpty()){
			System.out.println("nome obbligatorio! ");
		}else if (nomeCognome2==null || nomeCognome2.isEmpty()) {
			System.out.println("cognome obbligatorio! ");
		}else {
			//scorro lista utenti
			for (Utente u : listaUtenti) {
				String tmpNomeCognome = u.getNome() + " " + u.getCognome();
				//controllo esistenza 1°campo
				if (nomeCognome1.equals(tmpNomeCognome)) {
					utente = u;
				}
				//controllo esistenza 2°campo
				if (nomeCognome2.equals(tmpNomeCognome)) {
					amico = u;
				}
			}
			
			if ( utente != null && amico != null){
				utente.inserisciAmico(amico);
				amico.inserisciAmico(utente);
			}
		}
	}
	
	public void getAmiciDiUnUtente(String nome, String cognome) {
		Utente utente = null;
		
		if(nome==null || nome.isEmpty()){
			System.out.println("nome obbligatorio! ");
		}else if (cognome==null || cognome.isEmpty()) {
			System.out.println("cognome obbligatorio! ");
		}else {
			//controllo esistenza
			for (Utente u : listaUtenti) {
				if (u.getNome().equals(nome) && u.getCognome().equals(cognome)) {
					utente = u;
				}
			}
			if(utente!=null){
				System.out.println("\nLista amici di " + nome + " " + cognome +":");
				for (Utente u : utente.getListaAmici()) {//scorro e stampo lista amici dell'utente inserito
					String temp = u.getNome() + " " + u.getCognome();
					System.out.println("- "+temp);
				}
			}
		}	
	}

	public void getAmiciDiAmici(String nome, String cognome){
		Utente utente = null;
		String amiciDiAmici = "";
		
		for (Utente u : listaUtenti){
			if (u.getNome().equals(nome) && u.getCognome().equals(cognome)) {
				utente = u;
				List<Utente> amici = utente.getListaAmici();
				for (Utente u1 : amici) {
					List<Utente> amiciDiAmico = u1.getListaAmici();
					for (Utente u2 : amiciDiAmico) {
						if ((!u2.getNome().equals(nome)) && (!u2.getCognome().equals(cognome))) {
							amiciDiAmici += u2.getNome()+u2.getCognome()+"\n";
						
							System.out.print("\n");
							System.out.println("Lista di amici di amici di "+nome+" "+cognome+":\n"+amiciDiAmici);
						}
					}
				}
			}
		}
	}
	//
	public void getAmiciInComune(String utente1, String utente2){
		
		Utente utente = null;
		List<Utente> amiciUtente1 = null;
		List<Utente> amiciUtente2 = null;
		String amiciComune = "";
		
		System.out.println();
		
		//lista amici di utente 1 
		for (Utente u : listaUtenti){
			if (u.getNome() == utente1) {
				utente = u;
				amiciUtente1 = utente.getListaAmici();
				for(Utente u2: amiciUtente1){
					if(!u2.getNome().equals(utente2)) {
						System.out.println("primo ciclo: "+u2.getNome()+" "+u2.getCognome());
					}
				}
			}
		}
		//lista amici di utente 2 
		for (Utente u : listaUtenti){
			if (u.getNome() == utente2) {
				utente = u;
				amiciUtente2 = utente.getListaAmici();
				for(Utente u2: amiciUtente2){
					if(!u2.getNome().equals(utente1)) {
						System.out.println("secondo ciclo: "+u2.getNome()+" "+u2.getCognome());
					}
				}
			}
		}
		//amici in comune 
		for(Utente u: amiciUtente1){
			for(Utente u2: amiciUtente2) {
				if (u.getNome() == u2.getNome()){
					amiciComune = u2.getNome()+" "+u2.getCognome()+" ";
					System.out.println("terzo ciclo: "+amiciComune);
				}
			}
		}
	}
	
	public List<Utente> getListaUtenti() {
		return listaUtenti;
	}

	public void setListaUtenti(List<Utente> listaUtenti) {
		this.listaUtenti = listaUtenti;
	}
}
