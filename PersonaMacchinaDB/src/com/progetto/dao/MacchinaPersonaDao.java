package com.progetto.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.progetto.connDao.DataSource;
import com.progetto.entita.Macchina;
import com.progetto.entita.Persona;

public class MacchinaPersonaDao {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	public boolean _insert(Macchina m, Persona p) {
		boolean res = false;
		
		try {
			conn = DataSource.getInstance().getConnection();

			String sql = "insert into macchinapersona (id_macchina_fk, id_persona_fk) values (?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, m.getId_macchina());
			psmt.setInt(2, p.getId_persona());
			psmt.executeUpdate();
			
			res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public List<Macchina> getTutteMacchinePerPersona(int id_persona) {
		List<Macchina> listaMacchine = new ArrayList<Macchina>();
		try {
			conn = DataSource.getInstance().getConnection();

			String sql = 	"select m.ID_MACCHINA, m.MODELLO, m.TARGA"											+
							" from macchinapersona mp"															+ 
							" inner join macchina m on m.ID_MACCHINA = mp.ID_MACCHINA_FK"						+ 
							" inner join persona p on p.ID_PERSONA = mp.ID_PERSONA_FK"							+
							" where mp.ID_persona_fk = (SELECT id_persona FROM persona where id_persona = ?)";
			
//			String sql = 	"select m.id_macchina, m.modello, m.targa"	+
//							" from macchina m, MACCHINAPERSONA mp"		+
//							" WHERE m.ID_MACCHINA = mp.ID_MACCHINA_FK and mp.ID_PERSONA_FK = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id_persona);
			rs = psmt.executeQuery();
			while(rs.next()){
				int id_macchina = rs.getInt(1);
				String modello = rs.getString(2);
				String targa = rs.getString(3);
				
				Macchina m = new Macchina(id_macchina, modello, targa);
				m.setId_macchina(id_macchina);
				m.setModello(modello);
				m.setTarga(targa);
				
				listaMacchine.add(m);
				System.out.println("getListaMacchine: " + m.getId_macchina()+" "+m.getModello()+" "+m.getTarga());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		
		return listaMacchine;
	}
}
