package com.progetto.junit;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.progetto.dao.MacchinaDao;
import com.progetto.dao.MacchinaPersonaDao;
import com.progetto.dao.PersonaDao;
import com.progetto.entita.Macchina;
import com.progetto.entita.Persona;

public class TestMacchinaPersonaDao {
	static MacchinaPersonaDao mp;
	static MacchinaDao md; 
	static PersonaDao pd; 
	
	@BeforeClass
	public static void istanzaClassi() {
		mp = new MacchinaPersonaDao();
		md = new MacchinaDao();
		pd = new PersonaDao();
	}
	@Test
	public void testInserimento(){
		
		Macchina m = md._insert("Mercedes slk", "bv777pk");
		assertNotNull(m);
		
		Persona p = pd._insert("Gianluca","Buffon", "GNLBFN80B21L219E");
		assertNotNull(p);
		
		boolean res = mp._insert(m, p);
		assertTrue(res);
	}
}
