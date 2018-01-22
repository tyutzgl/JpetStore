package com.clps.demo.dao.Impl;

import java.util.List;

import com.clps.demo.domain.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.clps.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public void saveUser(User user) {
		// TODO userDao.saveUser

		hibernateTemplate.save(user);

	}

	@Override
	public User findUserById(int id) {
		// TODO userDao.findUserById
		User user = (User) hibernateTemplate.get(User.class, id);

		System.out.println("hibernate搭建成功");

		return user;
	}

	@Override
	public List<User> findUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUser(User user) {
		// TODO Auto-generated method stub

		hibernateTemplate.delete(user);
		
	}

	@Override
	public void updateUser(User user) {
		// TODO UserDao.updateUser

		hibernateTemplate.update(user);
		
	}


	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
