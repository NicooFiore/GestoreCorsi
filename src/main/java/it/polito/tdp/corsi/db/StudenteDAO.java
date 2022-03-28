package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.corsi.model.Corso;
import it.polito.tdp.corsi.model.Divisione;
import it.polito.tdp.corsi.model.Studente;

public class StudenteDAO {
	public List<Studente> getStudentiPerCorso(String codins) {
		String sql="SELECT s.matricola,s.cognome,s.nome,s.CDS "
				+ "from studente s, iscrizione i "
				+ "WHERE s.matricola=i.matricola AND i.codins=? ";
		List<Studente> result=new LinkedList<Studente>();
		
		try {
			Connection conn=ConnectDB.getConnection();
			PreparedStatement st= conn.prepareStatement(sql);
			st.setString(1, codins);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				Studente s=new Studente(rs.getInt("matricola"),rs.getString("cognome"),rs.getString("nome"),rs.getString("CDS"));
				result.add(s);
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
		public List<Divisione> getDivisioneStudenti(String codins){
			String sql="SELECT s.CDS,COUNT(*) AS n "
					+ "from studente s, iscrizione i "
					+ "WHERE s.matricola=i.matricola AND i.codins=? AND s.cds<>\"\" "
					+ "GROUP BY s.CDS";
			List<Divisione> result=new LinkedList<Divisione>();
			
			try {
				Connection conn=ConnectDB.getConnection();
				PreparedStatement st= conn.prepareStatement(sql);
				st.setString(1, codins);
				ResultSet rs=st.executeQuery();
				while(rs.next()) {
					Divisione s=new Divisione(rs.getString("CDS"),rs.getInt("n"));
					result.add(s);
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
