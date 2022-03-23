package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.librettovoti.db.LibrettoDAO;

public class Libretto {
	
	// ATTRIBUTI
	private List<Voto> voti;
	
	// COSTRUTTORE
	public Libretto()
	{
		this.voti = new ArrayList<Voto>();
	}
	
	// METODI
	/**
	 * permette di aggiungere al libretto un oggetto di classe Voto
	 * @param voto
	 * @return true se oggetto inserito; false altrimenti
	 */
	public boolean add(Voto voto)
	{
		LibrettoDAO dao = new LibrettoDAO();
		
		return dao.createVoto(voto);
	}

	/**
	 * restituisce tutti gli oggetti Voto
	 * @return lista di oggetti Voto
	 */
	public List<Voto> getVoti()
	{
		LibrettoDAO dao = new LibrettoDAO();
		
		return dao.readAllVoto();
	}
	
	@Override
	public String toString() 
	{
		String s = "";
		
		for(Voto v: voti)
		{
			if(s!="")
				s+="\n";
			
			s = s + v.toString();
		}
		
		return s;
	}
	
	


}
