package com.clps.jPet.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clps.jPet.domain.Account;
import com.clps.jPet.domain.Profile;
import com.clps.jPet.domain.Signon;

@Repository
public class RegisterDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void insertSigno(Signon signon) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(signon);

		tr.commit();
		session.close();
	}

	public void insertProfile(Profile profile) {

		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(profile);

		tr.commit();
		session.close();

	}

	public void insertAccount(Account account) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(account);

		tr.commit();
		session.close();

	}
}
