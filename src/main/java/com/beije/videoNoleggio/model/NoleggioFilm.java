package com.beije.videoNoleggio.model;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

public class NoleggioFilm {
	
	
	
	
	
	private Date data_noleggio;
	
	private Date data_scadenza;
	
	
	public Date getData_noleggio() {
		return data_noleggio;
	}
	public void setData_noleggio(Date data_noleggio) {
		this.data_noleggio = data_noleggio;
	}
	public Date getData_scadenza() {
		return data_scadenza;
	}
	public void setData_scadenza(Date data_scadenza) {
		this.data_scadenza = data_scadenza;
	}
	@Override
	public String toString() {
		return "NoleggioFilm:\n Data_noleggio: "
				+ getData_noleggio() + " Data_scadenza: " + getData_scadenza();
	}
	
	
	
	

}
