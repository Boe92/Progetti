package com.universita.entita;


import com.biblioteca.entita.*;
import com.universita.interfacce.ValidaDato;


public class Docente extends Utente implements ValidaDato{

	
	private String CF;

	

	public Docente(String nome, String cognome, String codiceFiscale) {
		super(nome, cognome);
		this.CF=codiceFiscale;
		
			}

	
	public String getCodiceFiscale() {
		return CF;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.CF = codiceFiscale;
	}
	
	
	@Override
	public boolean isValid() {

		boolean res = true;
		
		if((getNome()!=null || !getNome().isEmpty()) && (getCognome()!=null || !getCognome().isEmpty())) {
			res = true;		
		}
		
		return res;
	}
	

}
