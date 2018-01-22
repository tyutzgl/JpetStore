package com.clps.jPet.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clps.jPet.domain.Account;
import com.clps.jPet.domain.Inventory;
import com.clps.jPet.domain.Lineitem;
import com.clps.jPet.domain.Orders;
import com.clps.jPet.domain.Orderstatus;

@Repository
public class OrderDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Account queryAccount(String userid) {

		Session session = sessionFactory.openSession();

		Account account = (Account) session.get(Account.class, userid);

		session.close();
		return account;
	}

	public void saveOrder(Orders orders) {

		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		/*
		 * Orders order = new Orders(); order.setAccount(account);
		 * order.setOrderstatuses(orderstatus); order.setLineitems(lineitems);
		 */
		System.out.println(orders.toString());
		orders.setBilltolastname("liang");
		orders.setShiptolastname("liang");
		orders.setLocale("浦东软件园");
		session.save(orders);

		tr.commit();
		session.close();

	}

	public void saveLineitem(Lineitem lineitem) {

		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();

		
		session.save(lineitem);

		tr.commit();
		session.close();

	}

	public void saveOrderstatus(Orderstatus orderstatus) {

		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();

		session.save(orderstatus);

		tr.commit();
		session.close();

	}

	public List<Orders> queryOrder(String userid, int begin, int end) {

		Session session = sessionFactory.openSession();
		String hql = "from Orders where userid = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, userid);
		query.setFirstResult(begin);
		query.setMaxResults(end);
		List<Orders> orderslist = query.list();

		session.close();
		return orderslist;

	}

	public Orders queryOrdersOne(int orderid) {
		Session session = sessionFactory.openSession();
		Orders orders = (Orders) session.get(Orders.class, orderid);

		session.close();
		return orders;

	}

	public List<Inventory> queryInventory() {

		Session session = sessionFactory.openSession();
		String hql = "from Inventory";
		Query query = session.createQuery(hql);
		List<Inventory> inventorylist = query.list();
		session.close();
		return inventorylist;

	}

	public void updateInventory(Inventory inventory) {

		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();

		session.update(inventory);

		tr.commit();
		session.close();
	}

}
