package com.clps.jPet.dao.Impl;

import com.clps.jPet.dao.LoginDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clps.jPet.pojo.Account;
import com.clps.jPet.pojo.Profile;
import com.clps.jPet.pojo.Signon;

@Repository
public class LoginDaoImpl implements LoginDao {

    @Autowired
    private SessionFactory sessionFactory;

    public int userLogin(String userid, String password) {

        Session session = sessionFactory.openSession();

        String hql = "SELECT count(*) FROM Signon WHERE username = ? AND password = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0, userid);
        query.setParameter(1, password);
        Number num = (Number) query.uniqueResult();
        int result = num.intValue();
//		System.out.println(result);
        session.close();
        return result;
    }

    public Signon querySignon(String userid) {

        Session session = sessionFactory.openSession();

        Signon signon = (Signon) session.get(Signon.class, userid);

        session.close();
        return signon;

    }

    public Account queryAccount(String userid) {

        Session session = sessionFactory.openSession();

        Account account = (Account) session.get(Account.class, userid);

        session.close();
        return account;

    }

    public Profile queryProfile(String userid) {

        Session session = sessionFactory.openSession();

        Profile profile = (Profile) session.get(Profile.class, userid);

        session.close();
        return profile;

    }

    public void saveProfile(Profile profile) {

        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.update(profile);

        tr.commit();
        session.close();
    }
}
