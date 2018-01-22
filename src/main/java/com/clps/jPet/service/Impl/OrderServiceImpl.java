package com.clps.jPet.service.Impl;

import com.clps.jPet.dao.OrderDao;
import com.clps.jPet.pojo.*;
import com.clps.jPet.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderDao;

	public Account queryAccount(String userid) {

		return orderDao.queryAccount(userid);

	}

	public void saveOrders(Orders orders) {

		orderDao.saveOrder(orders);

	}

	public void saveLineitem(Lineitem lineitem) {

		orderDao.saveLineitem(lineitem);

	}

	public void saveOrderstatus(Orderstatus orderstatus) {

		orderDao.saveOrderstatus(orderstatus);

	}

	public List<Orders> queryOrder(String userid, int begin, int end) {

		return orderDao.queryOrder(userid, begin, end);

	}

	public List<Inventory> queryInventory() {

		return orderDao.queryInventory();

	}

	public void updateInventory(Inventory inventory) {
		orderDao.updateInventory(inventory);
	}

	public Orders queryOrdersOne(int orderid) {

		return orderDao.queryOrdersOne(orderid);
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
}
