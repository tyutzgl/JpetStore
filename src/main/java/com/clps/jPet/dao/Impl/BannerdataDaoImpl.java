package com.clps.jPet.dao.Impl;

import com.clps.jPet.dao.BannerdataDao;
import com.clps.jPet.pojo.Bannerdata;
import com.clps.jPet.pojo.Profile;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BannerdataDaoImpl implements BannerdataDao{

	@Autowired
	private SessionFactory sessionFactory;

	public Bannerdata querybanner(String userid) {
		Session session = sessionFactory.openSession();
		String hql = "FROM Bannerdata WHERE favcategory = (SELECT favcategory FROM Profile WHERE userid = ? )";
		Query query = session.createQuery(hql);
		query.setParameter(0, userid);
		List<Bannerdata> bannerdatalist = query.list();

		session.close();

		return bannerdatalist.get(0);
	}

	public Profile queryMyListOpf(String userid) {

		Session session = sessionFactory.openSession();

		String hql = "FROM Profile WHERE userid = ? ";
		Query query = session.createQuery(hql);
		query.setParameter(0, userid);
		List<Profile> profilelist = query.list();
		session.close();

		return profilelist.get(0);
	}

	public Bannerdata querybannerTwo(String userid) {

		Session session = sessionFactory.openSession();

		String hql = "FROM Bannerdata WHERE favcategory = (SELECT favcategory FROM Profile WHERE userid = ? )";
		Query query = session.createQuery(hql);
		query.setParameter(0, userid);
		List<Bannerdata> bannerdatalist = query.list();

		session.close();

		return bannerdatalist.get(0);
	}

	public Profile queryMyList(String userid) {

		Session session = sessionFactory.openSession();

		Profile profile = (Profile) session.get(Profile.class, userid);

		session.close();

		return profile;
	}
}
