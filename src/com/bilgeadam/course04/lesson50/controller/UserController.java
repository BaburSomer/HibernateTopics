package com.bilgeadam.course04.lesson50.controller;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.course04.lesson50.hibernate.DatabaseCRUDable;
import com.bilgeadam.course04.lesson50.model.User;

public class UserController implements DatabaseCRUDable<User>{

	@Override
	public void insert(User entity) {
		Session session = databaseConnection();
		session.getTransaction().begin();
		session.persist(entity);
		session.getTransaction().commit();
	}

	@Override
	public List<User> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User entity) {
		// TODO Auto-generated method stub
		
	}

}
