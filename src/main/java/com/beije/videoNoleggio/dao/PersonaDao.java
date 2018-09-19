package com.beije.videoNoleggio.dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.beije.videoNoleggio.model.*;
import com.beije.videoNoleggio.util.HibernateConnectionSingleton;

public class PersonaDao {
	
	private static SessionFactory sessionFactory;
	private static Session session;
	private static Transaction transaction ;
		
	
	public static void inserisciPersona(Persona persona) {
		sessionFactory = HibernateConnectionSingleton.getSessionFactory(); //con questo ottengo solo na connection
		session =  sessionFactory.openSession();
		transaction = session.beginTransaction();
		session.save(persona);
		transaction.commit();
		session.close();
		
	}
	
	public static void aggiornaPersona(Persona persona, int id) {
		sessionFactory = HibernateConnectionSingleton.getSessionFactory(); //con questo ottengo solo na connection
		session =  sessionFactory.openSession();
		Persona p2 =  session.load(Persona.class, id); //prima carico la persona che viene del db
		p2.setNome(persona.getNome());
		p2.setCognome(persona.getCognome());
		p2.setEmail(persona.getEmail());
		p2.setIndirizzo(persona.getIndirizzo());
		transaction = session.beginTransaction();
		session.merge(persona);
		transaction.commit();
		session.close();
		
	}
	
	public static Persona trovaPersonaById(int id) {
		sessionFactory = HibernateConnectionSingleton.getSessionFactory(); //con questo ottengo solo na connection
		session =  sessionFactory.openSession();
		Persona persona = session.load(Persona.class, id);
		return persona;
		
	}
	
	public static void deletePersona(int id) {
		sessionFactory = HibernateConnectionSingleton.getSessionFactory(); //con questo ottengo solo na connection
		session =  sessionFactory.openSession();
		Persona persona  =  session.load(Persona.class, id);
		transaction = session.beginTransaction();
		session.delete(persona);
		transaction.commit();
		session.close();
		
	}
	
	
	public static List<Persona> findAllPersona(){
		List<Persona> elencoPersona;
		sessionFactory = HibernateConnectionSingleton.getSessionFactory(); //con questo ottengo solo na connection
		session =  sessionFactory.openSession();
		transaction =session.beginTransaction();
		Query query = session.createQuery("from Persona"); 
		elencoPersona = query.list();
		transaction.commit();
		session.close();
		return elencoPersona;
		
	}

}
