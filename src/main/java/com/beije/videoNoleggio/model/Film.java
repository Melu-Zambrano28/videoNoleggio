package com.beije.videoNoleggio.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("hibernateLazyInitializer")
public class Film implements Serializable {
	
	private int id;
	private String nome;
	private String descrizione;
	private String tipo;
	private double prezzo;
	private int quantita;
	@JsonIgnore
	private List<Persona> elenco_persona;
	
	
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
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public List<Persona> getElenco_persona() {
		return elenco_persona;
	}
	public void setElenco_persona(List<Persona> elenco_persona) {
		this.elenco_persona = elenco_persona;
	}
	@Override
	public String toString() {
		return " Film id: " + getId() 
				+ " Nome: " + getNome() 
				+ " Descrizione: " + getDescrizione()
				+ " Tipo: " + getTipo()
				+ " Prezzo: " + getPrezzo() + " Quantita: " + getQuantita();
	}
	

}
