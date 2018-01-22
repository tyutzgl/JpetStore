package com.clps.jPet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.jPet.dao.OrderDao;
import com.clps.jPet.pojo.Account;
import com.clps.jPet.pojo.Inventory;
import com.clps.jPet.pojo.Lineitem;
import com.clps.jPet.pojo.Orders;
import com.clps.jPet.pojo.Orderstatus;

public interface OrderService {

    Account queryAccount(String userid);

    void saveOrders(Orders orders);

    void saveLineitem(Lineitem lineitem);

    void saveOrderstatus(Orderstatus orderstatus);

    List<Orders> queryOrder(String userid, int begin, int end);

    List<Inventory> queryInventory();

    void updateInventory(Inventory inventory);

    Orders queryOrdersOne(int orderid);

    OrderDao getOrderDao();

    void setOrderDao(OrderDao orderDao);
}
