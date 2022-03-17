package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.List;

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
	 * @return true se oggetto inserito; false se non è stato inserito (Voto duplicato o conflitto)
	 */
	public boolean add(Voto voto)
	{
		if(!isDuplicato(voto) && !isConflitto(voto))
		{
			this.voti.add(voto);
			return true;
		}
		
		return false;
	}
	
	/**
	 * restituisce un Libretto contenente tutti i voti
	 * il cui punteggio è passato per parametro
	 * @param punti Punteggio numerico 
	 * @return oggetto della classe Libretto 
	 */
	public Libretto filtraPunti(int punti)
	{
		Libretto ret = new Libretto();
		
		for(Voto v: voti)
		{
			if(v.getPunti() == punti)
			{
				ret.add(v);
			}
		}
		
		return ret;
	}
	
	/**
	 * Restituisce il punteggio ottenuto all'esame
	 * il cui nome è passato per parametro
	 * @param nome Nome dell'esame
	 * @return punteggio numerico, oppure {@code null} se l'esame non esiste
	 */
	public Integer getPuntiDatoNome(String nome)
	{
		for(Voto v: voti)
		{
			if(v.getNomeCorso().compareTo(nome)==0)
			{
				return v.getPunti();
			}
		}
		
		return null;
		// throw new IllegalArgumentException("Corso non trovato");
	}
	
	/**
	 * dato un Voto passato come parametro, 
	 * restituisce un boolean per capire se il voto è gia presente nel libretto (duplicato)
	 * (stesso nome, stesso punteggio)
	 * @param v oggetto di classe Voto
	 * @return true, se nel libretto esiste già lo stesso voto. false altrimenti.
	 */
	public boolean isDuplicato(Voto v)
	{
		for(Voto x: voti)
		{
			if(x.equals(v))
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * dato un Voto passato come parametro, 
	 * restituisce un boolean per capire se c'è un conflitto con i voti già presenti nel libretto
	 * (conflitto: stesso nome, punteggio diverso)
	 * @param v oggetto di classe voto
	 * @return true, se c'è un conflitto. false altrimenti.
	 */
	public boolean isConflitto(Voto v)
	{
		Integer punti = this.getPuntiDatoNome(v.getNomeCorso());
		
		if(punti != null && punti != v.getPunti())
		{
			return true;
		}
		
		return false;
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
	
	/**
	 * restituisce una lista contenente gli oggetti di classe Voto
	 * @return lista di voti
	 */
	public List<Voto> getVoti()
	{
		return this.voti;
	}
	
	/**
	 * restituisce un Libretto con i voti migliorati: 
	 * ciascun voto maggiore o uguale di 18 viene incrementato di 1 punto, 
	 * e ciascun voto maggiore o ugale di 24 viene incrementato di 2 punti 
	 * (senza superare il 30).
	 * @return oggetto di classe Libretto
	 */
	public Libretto votiMigliorati()
	{
		Libretto nuovo = new Libretto();
		
		for(Voto v: this.voti)
		{
			int punti = v.getPunti();
			
			if(punti < 24)
			{
				punti++;
			}
			if(punti >= 24)
			{
				punti = punti + 2;
			}
			if(punti > 30)
			{
				punti = 30;
			}
			
			nuovo.add(new Voto(v.getNomeCorso(), punti));
		}
		
		return nuovo;
	}
	
	/**
	 * elimina dal libretto tutti i voti con punteggio inferiore a quello passato per parametro
	 * @param punti
	 */
	public void cancellaVotiMinoriDi(int punti)
	{
		for(Voto v: this.voti)
		{
			if(v.getPunti() < punti)
			{
				voti.remove(v);
			}
		}
	}


}
