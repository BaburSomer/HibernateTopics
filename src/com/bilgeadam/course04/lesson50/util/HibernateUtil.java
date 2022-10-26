package com.bilgeadam.course04.lesson50.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bilgeadam.course04.lesson50.model.Billing;
import com.bilgeadam.course04.lesson50.model.ContactInformation;
import com.bilgeadam.course04.lesson50.model.Magazine;
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
		config.addAnnotatedClass(ContactInformation.class);
		config.addAnnotatedClass(Billing.class);
		config.addAnnotatedClass(Magazine.class);
		
		SessionFactory factory = config.configure("hibernate.cfg.xml").buildSessionFactory();
		
		return factory;
	}
}
