package it.polito.tdp.librettovoti.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.librettovoti.model.Voto;

public class LibrettoDAO {
	
	// METODI
	// Create Read Update (Delete)
	
	/**
	 * permette di inserire un nuovo Voto nel database
	 * @param v Oggetto di classe voto
	 * @return true, se voto inserito correttamente. false altrimenti
	 */
	public boolean createVoto(Voto v)
	{
		try
		{
			Connection conn = DBConnect.getConnection();
			
			String sql = "INSERT INTO libretto.voti (nome,punti) VALUES (?, ?)";
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, v.getNomeCorso());
			st.setInt(2, v.getPunti());
			
			int res = st.executeUpdate();
			
			st.close();
			
			conn.close();
			
			if(res == 1)
				return true;
			else
				return false;
			
			// return (res == 1);
			// restituisce true se res == 1  
				
		}
		catch(SQLException e)
		{
			System.out.println(e);
			e.printStackTrace();
			
			return false;
		}
	}
	
	/**
	 * 
	 * @return lista di tutti gli oggetti Voto presenti nel database
	 */
	public List<Voto> readAllVoto()
	{

		try 
		{
			Connection conn = DBConnect.getConnection();
			
			String sql = "SELECT * FROM voti";
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet res = st.executeQuery();
			
			List<Voto> result = new ArrayList<Voto>();
			
			while(res.next())
			{
				String nome = res.getString("nome");
				int punti = res.getInt("punti");
				
				result.add(new Voto(nome, punti));
			}
			
			st.close();
			
			conn.close();
			
			return result;
		} 
		catch (SQLException e) 
		{
			System.out.println(e);
			e.printStackTrace();
			
			return null;
		}
	}
	
	public Voto readVotoByName(String nome)
	{
		List<Voto> lista = this.readAllVoto();
		
		// da finire
		
		return null;
	}
	
	

}
