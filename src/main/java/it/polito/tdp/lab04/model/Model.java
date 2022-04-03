package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	StudenteDAO studenteDao;
	CorsoDAO corsoDao;
	
    public Model() {
		this.studenteDao = new StudenteDAO();
		this.corsoDao = new CorsoDAO();
	}

	
	public Studente cercaStudente(int matricola) {
		return this.studenteDao.getStudenteByMatricola(matricola);
	}
	
	public List<Studente> getStudentiByCorso(Corso c){
		return this.corsoDao.getStudentiIscrittiAlCorso(c);
	}
	
	public boolean isIscritto(Studente s, Corso c) {
		return this.corsoDao.isStudenteIscrittoACorso(s, c);
	}

}
