package com.bilgeadam.course04.lesson50.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bilgeadam.course04.lesson50.model.User;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (HibernateUtil.sessionFactory == null) {
			HibernateUtil.sessionFactory = createSessionFactory();
		}
		return HibernateUtil.sessionFactory;
	}

	private static SessionFactory createSessionFactory() {
		Configuration config = new Configuration();
		
		config.addAnnotatedClass(User.class);
		
		SessionFactory factory = config.configure("hibernate.cfg.xml").buildSessionFactory();
		
		return factory;
	}
}
