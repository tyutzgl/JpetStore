package com.clps.jPet.dao.Impl;

import com.clps.jPet.dao.RegisterDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clps.jPet.pojo.Account;
import com.clps.jPet.pojo.Profile;
import com.clps.jPet.pojo.Signon;

@Repository
public class RegisterDaoImpl implements RegisterDao{

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
