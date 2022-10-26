package com.bilgeadam.course04.lesson50.controller;

import java.util.ArrayList;

import org.hibernate.Session;

import com.bilgeadam.course04.lesson50.hibernate.DatabaseCRUDable;
import com.bilgeadam.course04.lesson50.model.ContactInformation;
import com.bilgeadam.course04.lesson50.model.User;
import com.bilgeadam.course04.lesson50.util.HibernateUtil;

import jakarta.persistence.TypedQuery;

public class ContactInformationController implements DatabaseCRUDable<ContactInformation>{

	@Override
	public ArrayList<ContactInformation> retrieve() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT xxx FROM ContactInformation AS xxx";  // <=== SQL'in aksine tablo adı değil okumak istediğimiz sınıf ismini yazıyoruz. Java sınıf adı yazım kurallarına uygun olmalı
		TypedQuery<ContactInformation> typedQuery = session.createQuery(hql, ContactInformation.class);
		
		ArrayList<ContactInformation> data = (ArrayList<ContactInformation>)typedQuery.getResultList();
		return data;
	}

	@Override
	public ContactInformation find(long oid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "SELECT xxx FROM ContactInformation AS xxx WHERE xxx.oid =: key";  
		TypedQuery<ContactInformation> typedQuery = session.createQuery(hql, ContactInformation.class);
		typedQuery.setParameter("key", oid);
		
		ContactInformation data = (ContactInformation)typedQuery.getSingleResult();
		return data;
	}
		
}
