package com.beije.videoNoleggio.mainTest;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.beije.videoNoleggio.dao.FilmDao;
import com.beije.videoNoleggio.dao.PersonaDao;
//import com.beije.model.Utente;
import com.beije.videoNoleggio.model.*;
import com.beije.videoNoleggio.util.HibernateConnectionSingleton;

public class mainTest {

	public static void main(String[] args) {
		/*
		String s = "prova";
		
		String a  = s.toUpperCase();
		s.concat(" di nuovo");
		System.out.println(s.toUpperCase());
		System.out.println(s);
		System.out.println(a +" a");*/
		
		
		
		Persona persona  = new Persona() ;
		persona.setNome("Raul");
		persona.setCognome("zambrano");
		persona.setIndirizzo("stazione Loreto");
		persona.setEmail("m.guzman@gmail.com");
		
		Film film = new Film ();
		film.setNome("L'evocazione 3");
		film.setDescrizione("Un casa maledetta terza parte ");
		film.setTipo("triller");
		film.setPrezzo(23.50);
		film.setQuantita(2);
		
		//FilmDao.inserisciFilm(film);
		List<Film> elencoFilm = FilmDao.findAllFilm();
		
		
		
		
	
		//PersonaDao.inserisciPersona(persona);
		//PersonaDao.aggiornaCliente(persona,6);
	
		  //List<Persona> elenco = PersonaDao.findAllPersona();
		
		  //session.save(persona);
		//session.save(film);
		//List <Persona> utenteList = session.createQuery("from noleggiofilm n join persona on n.id_persona = persona.id").list(); //tutti i clienti hquery
		

		
		

	}

}
