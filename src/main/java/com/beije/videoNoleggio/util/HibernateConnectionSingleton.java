package com.beije.videoNoleggio.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnectionSingleton {
	
	
	private static SessionFactory factory;
	
	private HibernateConnectionSingleton() {
		
	}
	
	//sicuro con multithread
	
	public static synchronized SessionFactory getSessionFactory() {

        if (factory == null) {
            factory = new Configuration().configure("hibernate.cfg.xml").
                    buildSessionFactory();
        }
        
        return factory;
    }
	
	

}
