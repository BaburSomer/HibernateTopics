package com.bilgeadam.course04.lesson50.controller;

import java.util.ArrayList;

import org.hibernate.Session;

import com.bilgeadam.course04.lesson50.hibernate.DatabaseCRUDable;
import com.bilgeadam.course04.lesson50.model.User;
import com.bilgeadam.course04.lesson50.util.HibernateUtil;

import jakarta.persistence.TypedQuery;

public class UserController implements DatabaseCRUDable<User>{

	@Override
	public ArrayList<User> retrieve() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT xxx FROM User AS xxx";  // <=== SQL'in aksine tablo adı değil okumak istediğimiz sınıf ismini yazıyoruz. Java sınıf adı yazım kurallarına uygun olmalı
		TypedQuery<User> typedQuery = session.createQuery(hql, User.class);
		
		ArrayList<User> users = (ArrayList<User>)typedQuery.getResultList();
		return users;
	}

	@Override
	public User find(long oid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "SELECT xxx FROM User AS xxx WHERE xxx.oid =: key";  
		TypedQuery<User> typedQuery = session.createQuery(hql, User.class);
		typedQuery.setParameter("key", oid);
		
		User user = (User)typedQuery.getSingleResult();
		return user;
	}
	
	public User findByFirstAndLastName(String firstName, String lastName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "SELECT xxx FROM User AS xxx WHERE xxx.firstName =: firstName AND xxx.lastName =: lastName";  
		TypedQuery<User> typedQuery = session.createQuery(hql, User.class);
		typedQuery.setParameter("firstName", firstName);
		typedQuery.setParameter("lastName", lastName);
		
		User user = (User)typedQuery.getSingleResult();
		return user;
	}
}
