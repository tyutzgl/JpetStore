package com.clps.jPet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.jPet.dao.ShoppingDao;
import com.clps.jPet.domain.Cart;

@Service
public class ShoppingService {

	@Autowired
	private ShoppingDao shoppingDao;

	public void saveShopping(Cart cart) {

		shoppingDao.saveShopping(cart);

	}

	public List<Cart> queryShopping(String username, int begin, int end) {
		// TODO Auto-generated method stub
		return shoppingDao.queryShopping(username, begin, end);
	}

	public int deleteShopping(String itemid, String userid) {

		return shoppingDao.deleteShopping(itemid, userid);
	}

	public int updateQuantity(int quantity, String itemid, String userid) {

		return shoppingDao.updateQuantity(quantity, itemid, userid);
	}

	public int queryCountShopping(String itemid, String userid) {

		return shoppingDao.queryCountShopping(itemid, userid);
	}

	public Cart queryOneShopping(String userid, String itemid) {

		return shoppingDao.queryOneShopping(userid, itemid);

	}

	public long count(String itemid, String userid) {

		return shoppingDao.count(itemid, userid);

	}

	public ShoppingDao getShoppingDao() {
		return shoppingDao;
	}

	public void setShoppingDao(ShoppingDao shoppingDao) {
		this.shoppingDao = shoppingDao;
	}

}
