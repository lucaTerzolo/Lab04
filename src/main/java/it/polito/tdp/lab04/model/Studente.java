package it.polito.tdp.lab04.model;

public class Studente {
	private Integer matricola;
	private String nome;
	private String cognome;
	
	public Studente(Integer matricola, String nome, String cognome) {
		super();
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
	}

	public Integer getMatricola() {
		return matricola;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + "]";
	}
	
	
}
