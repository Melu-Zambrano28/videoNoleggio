package com.beije.videoNoleggio.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.beije.videoNoleggio.model.Film;
import com.beije.videoNoleggio.model.Persona;
import com.beije.videoNoleggio.util.HibernateConnectionSingleton;

@Transactional
public class FilmDao {
	
	private static SessionFactory sessionFactory;
	private static Session session;
	private static Transaction transaction ;
		
	public static void inserisciFilm(Film film) {
		sessionFactory = HibernateConnectionSingleton.getSessionFactory(); //con questo ottengo solo na connection
		session =  sessionFactory.openSession();
		transaction = session.beginTransaction();
		session.save(film);
		transaction.commit();
		session.close();
		
	}
	
	public static void aggiornafilm(Film film, int id) {
		sessionFactory = HibernateConnectionSingleton.getSessionFactory(); //con questo ottengo solo na connection
		session =  sessionFactory.openSession();
		transaction = session.beginTransaction();
		Film filmDb =  session.load(Film.class, id); //prima carico la persona che viene del db
		filmDb.setNome(film.getNome());
		filmDb.setDescrizione(film.getDescrizione());
		filmDb.setPrezzo(film.getPrezzo());
		filmDb.setQuantita(film.getQuantita());
		filmDb.setTipo(film.getTipo());		
		session.merge(filmDb);
		transaction.commit();
		session.close();
		
	}
	
	public static Film trovaFilmById(int id) {
		sessionFactory = HibernateConnectionSingleton.getSessionFactory(); //con questo ottengo solo na connection
		session =  sessionFactory.openSession();
		Film film = session.load(Film.class, id);
		return film;
		
	}
	
	public static Film trovaFilmByNome(String nome) {
		sessionFactory = HibernateConnectionSingleton.getSessionFactory(); //con questo ottengo solo na connection
		session =  sessionFactory.openSession();
		Film film  = session.createQuery("from Film where nome=?1" , Film.class).setParameter(1, nome).uniqueResult();
		return film;
	}
	
	
	public static void deleteFilm(int id) {
		sessionFactory = HibernateConnectionSingleton.getSessionFactory(); //con questo ottengo solo na connection
		session =  sessionFactory.openSession();
		Film film  =  session.load(Film.class, id);
		transaction = session.beginTransaction();
		session.delete(film);
		transaction.commit();
		session.close();
		
	}
	
	public static List<Film> findAllFilm(){
		List<Film> elencoFilm;
		sessionFactory = HibernateConnectionSingleton.getSessionFactory(); //con questo ottengo solo na connection
		session =  sessionFactory.openSession();
		Query query = session.createQuery("from Film"); 
		elencoFilm = query.list();
		
		return elencoFilm;
		
	}
	

}
