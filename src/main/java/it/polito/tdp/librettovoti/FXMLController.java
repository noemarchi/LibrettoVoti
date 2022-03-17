package it.polito.tdp.librettovoti;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.Libretto;
import it.polito.tdp.librettovoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private ComboBox<Integer> cmbPunti;
    @FXML
    private TextField txtNome;
    @FXML
    private TextArea txtVoti;
    @FXML
    private Label lblErrore;
    @FXML
    private Label lblTitolo;
    
    private Libretto model;
    
    
    
    @FXML
    void handleNuovoVoto(ActionEvent event) 
    {
    	// 1: acquisizione e controllo dei dati
    	String nome = this.txtNome.getText();
    	Integer punti = this.cmbPunti.getValue();
    	
    	// controllo dati non inseriti
    	if(nome.equals("") || punti == null)
    	{
    		this.lblErrore.setText("ERRORE: occorre inserire nome e voto!");
    		
    		this.txtNome.clear();
        	this.cmbPunti.setValue(null);
    		
    		return;
    	}
    	
    	// 2: esecuzione dell'operazione (= chiedere al Model di farla)
    	boolean inserito = model.add(new Voto(nome, punti));
    	
    	if(!inserito)
    	{
    		this.lblErrore.setText("ERRORE: esame già presente");
    		
    		this.txtNome.clear();
        	this.cmbPunti.setValue(null);
    		
    		return;
    	}
    	
    	// 3: visualizzazione/aggiornamento del risultato
    	List<Voto> voti = model.getVoti();
    	
    	this.txtVoti.clear();
    	this.txtVoti.appendText("Hai superato " + voti.size() + " esami!\n");
    	for(Voto v: voti)
    	{
    		this.txtVoti.appendText(v.toString() + "\n");
    	}
    	
    	this.txtNome.clear();
    	this.cmbPunti.setValue(null);
    	
    	this.lblErrore.setText("");
    }
    
    void setModel(Libretto model)
    {
    	this.model = model;
    	
    	this.lblTitolo.setText("Libretto voti");
    }

    @FXML
    void initialize() 
    {
        assert cmbPunti != null : "fx:id=\"cmbPunti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoti != null : "fx:id=\"txtVoti\" was not injected: check your FXML file 'Scene.fxml'.";

        // aggiungo alla tendina dei punteggi i valori da 18 a 30
        this.cmbPunti.getItems().clear();
        
        for(int x = 18; x<=30; x++)
        {
        	this.cmbPunti.getItems().add(x);
        }
        
        // this.lblTitolo.setText("Libretto voti");
    }

}