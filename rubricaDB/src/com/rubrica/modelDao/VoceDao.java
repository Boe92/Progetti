package com.rubrica.modelDao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rubrica.connDao.DataSource;
import com.rubrica.entita.Voce;

public class VoceDao {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	
	public Voce _select(int id_voce) {
		
		Voce v = null;
		try {
			conn = DataSource.getInstance().getConnection();
			
			String sql = "select * from voce where id_voce = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id_voce);
			
			rs = psmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String cognome = rs.getString(3);
				String telefono = rs.getString(4);
				
				v = new Voce(id_voce, nome, cognome, telefono);
				System.out.println("GetVoce: " + id+" "+nome+" "+cognome+" "+telefono);
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
		
		return v;
	}
	
	public List<Voce> _selectAll() {
		
		List<Voce> listaVoci = new ArrayList<>();
		try {
			conn = DataSource.getInstance().getConnection();
			
			String sql = "select * from voce order by id_voce asc";
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			while(rs.next()){
				int id_voce = rs.getInt(1);
				String nome = rs.getString(2);
				String cognome = rs.getString(3);
				String telefono = rs.getString(4);
				
				Voce v = new Voce(id_voce, nome, cognome, telefono);
				v.setId_voce(id_voce);
				v.setNome(nome);
				v.setNome(cognome);
				v.setNome(telefono);
				
				listaVoci.add(v);
				System.out.println("getListaVoci: " + id_voce+" "+nome+" "+cognome+" "+telefono);
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
		
		return listaVoci;
	}
	
	public boolean _insert(String nome, String cognome, String telefono, int id) {
		
		boolean res = false;
		try {
			conn = DataSource.getInstance().getConnection();
			
			String sql = "insert into voce (nome, cognome, telefono, id_rubrica_fk) values (?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, nome);
			psmt.setString(2, cognome);
			psmt.setString(3, telefono);
			psmt.setInt(4, id);
			
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
	
	public void _update(String nome, String cognome, String telefono, int id_voce) {
		try {
			conn = DataSource.getInstance().getConnection();
			
			String sql = "update voce set nome = ?, cognome = ?, telefono = ? where id_voce = ?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, nome);
			psmt.setString(2, cognome);
			psmt.setString(3, telefono);
			psmt.setInt(4, id_voce);
			
			psmt.executeUpdate();
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
	}
	
	public void _delete(int id_voce) {
		try {
			conn = DataSource.getInstance().getConnection();
			
			String sql = "delete from voce where id_voce = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id_voce);
			psmt.executeUpdate();
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
	}
}
