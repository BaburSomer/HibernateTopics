package com.bilgeadam.course04.lesson50.hibernate;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.course04.lesson50.util.HibernateUtil;

public interface DatabaseCRUDable<T> {
	void insert(T entity);   // create yerine
	List<T> retrieve();
	void update(T entity);
	void delete(T entity);
	
	default T find(long oid) {
		return null;
	}
	
	default Session databaseConnection() {
		return HibernateUtil.getSessionFactory().openSession();
	}
}
