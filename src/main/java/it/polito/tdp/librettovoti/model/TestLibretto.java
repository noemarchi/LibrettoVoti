package it.polito.tdp.librettovoti.model;

public class TestLibretto {

	public static void main(String[] args) {
		
		Libretto lib = new Libretto();
		
		/*
		lib.add(new Voto("Fisica 1", 27));
		lib.add(new Voto("Statistica", 22));
		lib.add(new Voto("Storia energia", 25));
		lib.add(new Voto("Algebra", 26));
		lib.add(new Voto("Sistemi elettrici", 30));
		lib.add(new Voto("Basi data", 30));
		lib.add(new Voto("Programmazione gestione produzione", 20));
		lib.add(new Voto("Ricerca operativa", 26));
		lib.add(new Voto("Chimica", 29));
		lib.add(new Voto("Sistemi telematici", 25));
		lib.add(new Voto("Economia", 28));
		lib.add(new Voto("Diritto", 25));
		lib.add(new Voto("Informatica", 28));
		lib.add(new Voto("Programmazione oggetti", 30));
		lib.add(new Voto("Analisi 1", 28));
		lib.add(new Voto("Sistemi produzione", 26));
		lib.add(new Voto("Analisi 2", 21));
		lib.add(new Voto("Fisica 2", 23));
		*/
		
		//System.out.println(lib);
		
		/*
		
		System.out.println("*** Esami con voti pari a 25 ***");
		Libretto lib25 = lib.filtraPunti(25);
		System.out.println(lib25);
		
		System.out.println("\n*** Voto dell'esame di Informatica ***");
		if(lib.getPuntiDatoNome("Informatica") == null)
		{
			System.out.println("Errore: esame non trovato");	
		}
		else
		{
			System.out.println(lib.getPuntiDatoNome("Informatica"));
		}
		System.out.println("\n*** Voto dell'esame di Inglese ***");
		if(lib.getPuntiDatoNome("Inglese") == null)
		{
			System.out.println("Errore: esame non trovato!");	
		}
		else
		{
			System.out.println(lib.getPuntiDatoNome("Inglese"));
		}
		
		System.out.println("\n*** Analisi 1 30 è in conflitto con qualche voto del libretto? ***");
		if(lib.isConflitto(new Voto("Analisi 1", 30)))
		{
			System.out.println("c'è conflitto!");
		}
		else
		{
			System.out.println("non c'è conflitto!");
		}
		
		System.out.println("\n*** Fisica 1 27 è gia presente nel libretto? ***");
		if(lib.isDuplicato(new Voto("Fisica 1", 27)))
		{
			System.out.println("si. duplicato");
		}
		else
		{
			System.out.println("no. non duplicato");
		}
		
		*/
	}

}
