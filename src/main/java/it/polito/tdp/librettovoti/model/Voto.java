package it.polito.tdp.librettovoti.model;

public class Voto {
	
	// ATTRIBUTI
	private String nomeCorso;
	private int punti;
	// String dataEsame;
	
	// COSTRUTTORE
	public Voto(String nomeCorso, int punti) 
	{
		super();
		this.nomeCorso = nomeCorso;
		this.punti = punti;
	}

	// GETTER & SETTER
	public String getNomeCorso() 
	{
		return nomeCorso;
	}

	public void setNomeCorso(String nomeCorso) 
	{
		this.nomeCorso = nomeCorso;
	}

	public int getPunti() 
	{
		return punti;
	}

	public void setPunti(int punti) 
	{
		this.punti = punti;
	}

	@Override
	public String toString() 
	{
		return nomeCorso + ": " + punti;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeCorso == null) ? 0 : nomeCorso.hashCode());
		result = prime * result + punti;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voto other = (Voto) obj;
		if (nomeCorso == null) {
			if (other.nomeCorso != null)
				return false;
		} else if (!nomeCorso.equals(other.nomeCorso))
			return false;
		if (punti != other.punti)
			return false;
		return true;
	}

	
	
	
	
	
	
	
	
	
	

}
