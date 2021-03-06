package com.facebook.output;

import com.facebook.action.Facebook;
import com.facebook.entity.Utente;

public class TestFacebook {

	public static void main(String[] args) {

		Facebook f = new Facebook();

		Utente u1 = new Utente("Marco", "Boemi",24, 'M', "aaaa@aaa.com");
		Utente u2 = new Utente("Luca", "Boemi",24, 'M', "aaaa@aaa.com");
		Utente u3 = new Utente("Fabrizio", "Boemi",24, 'M', "aaaa@aaa.com");
		Utente u4 = new Utente("Davide", "Boemi", 12, 'M', "aaaa@aaa.com");
		Utente u5 = new Utente("Giancarlo", "Boemi", 28, 'M', "aaaa@aaa.com");

		
		f.registraUtente(u1.getNome(), u1.getCognome(),u1.getEta(), u1.getSesso(), u1.getEmail());
		f.registraUtente(u2.getNome(), u2.getCognome(),u2.getEta(), u2.getSesso(), u2.getEmail());
		f.registraUtente(u3.getNome(), u3.getCognome(),u3.getEta(), u3.getSesso(), u3.getEmail());
		f.registraUtente(u4.getNome(), u4.getCognome(),u4.getEta(), u4.getSesso(), u4.getEmail());
		f.registraUtente(u5.getNome(), u5.getCognome(),u5.getEta(), u5.getSesso(), u5.getEmail());
		
		
		f.aggiungiAmici(u1.getNome() + " " + u1.getCognome(), u2.getNome() + " " + u2.getCognome());
		f.aggiungiAmici(u1.getNome() + " " + u1.getCognome(), u3.getNome() + " " + u3.getCognome());
		f.aggiungiAmici(u1.getNome() + " " + u1.getCognome(), u4.getNome() + " " + u4.getCognome());
		f.aggiungiAmici(u1.getNome() + " " + u1.getCognome(), u5.getNome() + " " + u5.getCognome());
		f.aggiungiAmici(u2.getNome() + " " + u2.getCognome(), u3.getNome() + " " + u3.getCognome());
		f.aggiungiAmici(u2.getNome() + " " + u2.getCognome(), u4.getNome() + " " + u4.getCognome());


		f.getAmiciDiUnUtente(u1.getNome(), u1.getCognome());
		
		f.getAmiciDiAmici(u1.getNome(), u1.getCognome());
		
		f.getAmiciInComune(u1.getNome(), u2.getNome());

	}
}
