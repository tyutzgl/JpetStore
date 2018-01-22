package com.clps.jPet.dao.Impl;

import java.util.List;

import com.clps.jPet.dao.ShoppingDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clps.jPet.pojo.Cart;

@Repository
public class ShoppingDaoImpl implements ShoppingDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void saveShopping(Cart cart) {

		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();

		session.save(cart);

		tr.commit();
		session.close();
	}

	public List<Cart> queryShopping(String userid, int begin, int end) {

		Session session = sessionFactory.openSession();

		String hql = "FROM Cart WHERE userid = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, userid);
		query.setFirstResult(begin);
		query.setMaxResults(end);
		List<Cart> cartlist = query.list();

		session.close();
		return cartlist;

	}

	public int deleteShopping(String itemid, String userid) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String hql = "DELETE FROM Cart WHERE itemid = ? AND userid = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, itemid);
		query.setParameter(1, userid);
		int result = query.executeUpdate();

		tx.commit();
		session.close();
		return result;

	}

	public int updateQuantity(int quantity,String itemid,String userid){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "UPDATE Cart SET quantity = ? where itemid = ? and userid=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, quantity);
		query.setParameter(1, itemid);
		query.setParameter(2, userid);
		int result = query.executeUpdate();
		
		tx.commit();
		session.close();
		return result;
		
		
	}

	public int queryCountShopping(String itemid, String userid) {
		Session session = sessionFactory.openSession();
		String hql = "SELECT count(*) FROM Cart WHERE itemid = ? AND userid = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, itemid);
		query.setParameter(1, userid);

		Number num = (Number) query.uniqueResult();
		int i = num.intValue();
		session.close();
		return i;
	}

	public Cart queryOneShopping(String userid, String itemid) {

		Session session = sessionFactory.openSession();

		String hql = "FROM Cart WHERE userid = ? AND itemid=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, userid);
		query.setParameter(1, itemid);
		Cart cart = (Cart) query.uniqueResult();

		session.close();
		return cart;

	}

	public long count(String itemid, String userid) {
		Session session = sessionFactory.openSession();

		String hql = "SELECT quantity FROM Cart WHERE userid = ? AND itemid=?";
		Query query = session.createQuery(hql);

		query.setParameter(0, userid);
		query.setParameter(1, itemid);
		long i = (Long) query.uniqueResult();

		session.close();
		return i;

	}
}
