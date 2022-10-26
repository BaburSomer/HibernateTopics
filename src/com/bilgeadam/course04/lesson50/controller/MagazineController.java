package com.bilgeadam.course04.lesson50.controller;

import java.util.ArrayList;

import org.hibernate.Session;

import com.bilgeadam.course04.lesson50.hibernate.DatabaseCRUDable;
import com.bilgeadam.course04.lesson50.model.Magazine;
import com.bilgeadam.course04.lesson50.util.HibernateUtil;

import jakarta.persistence.TypedQuery;

public class MagazineController implements DatabaseCRUDable<Magazine>{

	@Override
	public ArrayList<Magazine> retrieve() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT xxx FROM Magazine AS xxx";  // <=== SQL'in aksine tablo adı değil okumak istediğimiz sınıf ismini yazıyoruz. Java sınıf adı yazım kurallarına uygun olmalı
		TypedQuery<Magazine> typedQuery = session.createQuery(hql, Magazine.class);
		
		ArrayList<Magazine> data = (ArrayList<Magazine>)typedQuery.getResultList();
		return data;
	}

	@Override
	public Magazine find(long oid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "SELECT xxx FROM Magazine AS xxx WHERE xxx.oid =: key";  
		TypedQuery<Magazine> typedQuery = session.createQuery(hql, Magazine.class);
		typedQuery.setParameter("key", oid);
		
		Magazine data = (Magazine)typedQuery.getSingleResult();
		return data;
	}
	
}
