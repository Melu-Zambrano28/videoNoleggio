package com.beije.videoNoleggio.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("hibernateLazyInitializer")
public class Persona implements Serializable {
	
	private int id;
	private String nome;
	private String cognome;
	private String email;
	private String indirizzo;
	private List<Film> elenco_films;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public List<Film> getElenco_films() {
		return elenco_films;
	}
	public void setElenco_films(List<Film> elenco_films) {
		this.elenco_films = elenco_films;
	}
	public String toString() {
		return "Nome: "+this.getNome()+ " Cognome: "+this.getCognome()+" Email: "+this.getEmail()+" Indirizzo: "+this.getIndirizzo();
	}
}
