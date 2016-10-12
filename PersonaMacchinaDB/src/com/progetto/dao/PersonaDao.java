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
import com.progetto.entita.Persona;

public class PersonaDao {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	
	public Persona _select(int id_persona) {
		
		Persona p = null;
		try {
			conn = DataSource.getInstance().getConnection();
			
			String sql = "select * from persona where id_persona = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id_persona);
			
			rs = psmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String cognome = rs.getString(3);
				String CF = rs.getString(4);
				
				p = new Persona(id, nome, cognome, CF);
				System.out.println("GetPersona: " + id+" "+nome+" "+cognome+" "+CF);
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
		
		return p;
	}
	
	public List<Persona> _selectAll() {
		
		List<Persona> listaPersone = new ArrayList<>();
		try {
			conn = DataSource.getInstance().getConnection();
			
			String sql = "select * from persona order by id_persona asc";
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			while(rs.next()){
				int id_persona = rs.getInt(1);
				String nome = rs.getString(2);
				String cognome = rs.getString(3);
				String CF = rs.getString(4);
				
				Persona p = new Persona(id_persona, nome, cognome, CF);
				p.setId_persona(id_persona);
				p.setNome(nome);
				p.setCognome(cognome);
				p.setCF(CF);
				
				listaPersone.add(p);
				System.out.println("getListaPersone: " + id_persona+" "+nome+" "+cognome+" "+CF);
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
		
		return listaPersone;
	}
	
	public Persona _insert(String nome, String cognome, String CF) {
		Persona p = null;
		
		try {
			conn = DataSource.getInstance().getConnection();
			
			String sql = "insert into persona (nome, cognome, CF) values (?,?,?)";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, nome);
			psmt.setString(2, cognome);
			psmt.setString(3, CF);
			psmt.executeUpdate();
			
			int id = getLastInsertIdPersona();
			p = new Persona(id, nome, cognome, CF);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		
		return p;
	}
	
	public int getLastInsertIdPersona() {
		int id = 0;
		String sql = "select max(id_persona) from persona";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()){
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	public boolean _update(String nome, String cognome, String CF, int id_persona) {
		
		boolean res = false;
		try {
			conn = DataSource.getInstance().getConnection();
			
			String sql = "update persona set nome = ?, cognome = ?, CF = ? where id_persona = ?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, nome);
			psmt.setString(2, cognome);
			psmt.setString(3, CF);
			psmt.setInt(4, id_persona);
			
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
	
	public boolean _delete(int id_persona) {
		
		boolean res = false;
		try {
			conn = DataSource.getInstance().getConnection();
			
			String sql = "delete from persona where id_persona = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id_persona);
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
