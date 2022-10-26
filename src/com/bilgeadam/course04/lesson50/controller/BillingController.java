package com.bilgeadam.course04.lesson50.controller;

import java.util.ArrayList;

import org.hibernate.Session;

import com.bilgeadam.course04.lesson50.hibernate.DatabaseCRUDable;
import com.bilgeadam.course04.lesson50.model.Billing;
import com.bilgeadam.course04.lesson50.util.HibernateUtil;

import jakarta.persistence.TypedQuery;

public class BillingController implements DatabaseCRUDable<Billing>{

	@Override
	public ArrayList<Billing> retrieve() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT xxx FROM Billing AS xxx";  // <=== SQL'in aksine tablo adı değil okumak istediğimiz sınıf ismini yazıyoruz. Java sınıf adı yazım kurallarına uygun olmalı
		TypedQuery<Billing> typedQuery = session.createQuery(hql, Billing.class);
		
		ArrayList<Billing> data = (ArrayList<Billing>)typedQuery.getResultList();
		return data;
	}

	@Override
	public Billing find(long oid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "SELECT xxx FROM Billing AS xxx WHERE xxx.oid =: key";  
		TypedQuery<Billing> typedQuery = session.createQuery(hql, Billing.class);
		typedQuery.setParameter("key", oid);
		
		Billing data = (Billing)typedQuery.getSingleResult();
		return data;
	}
	
}
