package com.progetto.junit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.progetto.dao.MacchinaDao;
import com.progetto.entita.Macchina;

public class TestMacchinaDao {
	static MacchinaDao md;
		
	@BeforeClass
	public static void testIstanzaClasseDao(){
		md = new MacchinaDao();		
	}
	@Test
	public void testInserimento(){
		Macchina m = md._insert("Alfa Romeo", "BZ456CF");
		assertNotNull(m);
	}
	
	@Test
	public void testAggiorna(){
		boolean res = md._update("Ferrari", "AA111ZZ", 3);
		assertTrue(res);
	}
	@Test
	public void testSelezione(){
		Macchina m = md._select(11);
		assertNotNull(m);
	}
	@Test
	public void testCancella(){
		boolean res = md._delete(3);
		assertTrue(res);
	}
}
