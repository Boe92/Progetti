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

public class MacchinaDao {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	
	public Macchina _select(int id_macchina) {
		Macchina m = null;
		try {
			conn = DataSource.getInstance().getConnection();
			
			String sql = "select * from macchina where id_macchina = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id_macchina);
			
			rs = psmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt(1);
				String modello = rs.getString(2);
				String targa = rs.getString(3);
				
				m = new Macchina(id, modello, targa);
				System.out.println("MacchinaDao - Select: " + id+" "+modello+" "+targa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return m;
	}
	
	public List<Macchina> _selectAll() {
		
		List<Macchina> listaMacchine = new ArrayList<>();
		try {
			conn = DataSource.getInstance().getConnection();
			
			String sql = "select * from macchina order by id_macchina asc";
			psmt = conn.prepareStatement(sql);
			
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
		} finally {
			try {
				psmt.close();
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listaMacchine;
	}
	
	public Macchina _insert(String modello, String targa) {
		
		System.out.print("MacchinaDao - insert");
		Macchina m = null;
		try {
			conn = DataSource.getInstance().getConnection();
			
			String sql = "insert into macchina (modello, targa) values (?, ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, modello);
			psmt.setString(2, targa);
			psmt.executeUpdate();
			
			int id = getLastInsertIdMacchina();
			m = new Macchina(id, modello, targa);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} 
		
		return m;
	}
	
	public int getLastInsertIdMacchina() {
		int id = 0;
		String sql = "select id_macchina from macchina";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()){
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	public boolean _update(String modello, String targa, int id_macchina) {
		
		boolean res = false;
		try {
			conn = DataSource.getInstance().getConnection();
			
			String sql = "update macchina set modello = ?, targa = ? where id_macchina = ?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, modello);
			psmt.setString(2, targa);
			psmt.setInt(3, id_macchina);
			psmt.executeUpdate();
			
			res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}
	
	public boolean _delete(int id_macchina) {
		
		boolean res = false;
		try {
			conn = DataSource.getInstance().getConnection();
			
			String sql = "delete from macchina where id_macchina = ?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, id_macchina);
			
			psmt.executeUpdate();
			
			res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}
}
