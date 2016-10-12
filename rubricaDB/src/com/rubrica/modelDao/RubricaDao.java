package com.rubrica.modelDao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rubrica.connDao.DataSource;

public class RubricaDao {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	
	public void _select(int id_rubrica) {
		try {
			conn = DataSource.getInstance().getConnection();
			
			String sql = "select * from rubrica where id_rubrica = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id_rubrica);
			
			rs = psmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				
				System.out.println(id+" "+nome);
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
	}
	
	public int _insert(String nome) {
		try {
			conn = DataSource.getInstance().getConnection();
			
			String sql = "insert into rubrica (nome) values (?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, nome);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} 
		
		return getIdRubrica();
	}
	
	public int getIdRubrica() {
		int id = 0;
		String sql = "SELECT max(ID_RUBRICA) FROM RUBRICA";
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
	
	public void _update(String nome, int id_rubrica) {
		try {
			conn = DataSource.getInstance().getConnection();
			
			String sql = "update rubrica set nome = ? where id_rubrica = ?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, nome);
			psmt.setInt(2, id_rubrica);
			
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
	
	public void _delete(int id_rubrica) {
		try {
			conn = DataSource.getInstance().getConnection();
			
			String sql = "delete * from rubrica where id_rubrica = ?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, id_rubrica);
			
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
