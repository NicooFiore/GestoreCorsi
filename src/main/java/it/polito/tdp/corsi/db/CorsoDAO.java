package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.corsi.model.Corso;

public class CorsoDAO {
public List<Corso> getCorsoByPeriodo(int periodo) {
	String sql="SELECT* "
			+ "FROM corso "
			+ "where pd=? ";
	List<Corso> result= new LinkedList<Corso>();
	try {
		Connection conn=ConnectDB.getConnection();
		PreparedStatement st= conn.prepareStatement(sql);
		st.setInt(1, periodo);
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			Corso c= new Corso(rs.getString("codins"),rs.getInt("crediti"),rs.getString("nome"),rs.getInt("pd"));
			result.add(c);
		}
		st.close();
		rs.close();
		conn.close();
		return result;
		
	}
	catch(SQLException e) {
		System.err.println("Errore nel DAO");
		e.printStackTrace();
		return null;
	}
	
	
}
public List<Corso> getStudentiPerCorsoPerPeriodo(int periodo){
	String sql="SELECT c.codins,c.crediti,c.nome,c.pd,count(*) AS n "
			+ "FROM corso c,iscrizione i "
			+ "WHERE c.codins=i.codins AND c.pd=? "
			+ "GROUP BY c.codins,c.crediti,c.nome,c.pd ";
	List<Corso> result= new LinkedList<Corso>();
	try {
		Connection conn=ConnectDB.getConnection();
		PreparedStatement st= conn.prepareStatement(sql);
		st.setInt(1, periodo);
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			Corso c= new Corso(rs.getString("codins"),rs.getInt("crediti"),rs.getString("nome"),rs.getInt("pd"));
			c.setNumIscritti(rs.getInt("n"));
			result.add(c);
		}
		st.close();
		rs.close();
		conn.close();
		return result;
		
	}
	catch(SQLException e) {
		System.err.println("Errore nel DAO");
		e.printStackTrace();
		return null;
	}
	
}
}
