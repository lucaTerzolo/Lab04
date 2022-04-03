package it.polito.tdp.lab04;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;
import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	StudenteDAO studenteDao;
	CorsoDAO corsoDao;
	
    public FXMLController() {
		this.studenteDao = new StudenteDAO();
		this.corsoDao = new CorsoDAO();
	}
    private Model model;

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> cmbCorsi;

    @FXML
    private TextField txtCognome;

    @FXML
    private TextField txtMatricola;

    @FXML
    private TextField txtNome;

    @FXML
    private TextArea txtStampa;

    @FXML
    void CercaIscrittiCorso(ActionEvent event) {
    	txtStampa.clear();
    	if(cmbCorsi.getValue()==null) {
    		txtStampa.setText("Selezionare corso");
    		return;
    	}
    	String codins=cmbCorsi.getValue();
    	Corso c=new Corso(codins,0,null,0);
    	List<Studente> s=this.model.getStudentiByCorso(c);
    	for(Studente si:s)
    		txtStampa.appendText(si.toString()+"\n");
    }

    @FXML
    void cercaCorsi(ActionEvent event) {
    	int matricola=Integer.parseInt(txtMatricola.getText());
    	String codins=cmbCorsi.getValue(); 
    	Studente s=new Studente(matricola,null,null);
    	Corso c=new Corso(codins,0,null,0);
    	if(this.model.isIscritto(s, c))
    		txtStampa.setText("Iscritto al corso");
    	else
    		txtStampa.setText("Non iscritto al corso");
    }
    
    @FXML
    void cercaStudente(ActionEvent event) {
    	int matricola=0;
    	try {
    	matricola=Integer.parseInt(txtMatricola.getText());
    	}catch(NumberFormatException e) {
    		System.out.print("ERRORE");
    	}
    	Studente s=this.model.cercaStudente(matricola);
    	txtNome.setText(s.getNome());
    	txtCognome.setText(s.getCognome());
    }


    @FXML
    void iscrivi(ActionEvent event) {

    }

    @FXML
    void reset(ActionEvent event) {
    	txtStampa.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	txtMatricola.clear();
    }

    @FXML
    void initialize() {
        assert cmbCorsi != null : "fx:id=\"cmbCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtStampa != null : "fx:id=\"txtStampa\" was not injected: check your FXML file 'Scene.fxml'.";

       List<String> corsi=this.corsoDao.getCorsi();
        for(int i=0;i<corsi.size();i++) {
        	cmbCorsi.getItems().add(corsi.get(i));
        }
    }
    
    public void setModel(Model model) {
    	this.model = model;
    }

}
