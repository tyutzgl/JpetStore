package com.clps.jPet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.jPet.dao.ShoppingDao;
import com.clps.jPet.pojo.Cart;

public interface ShoppingService {

    void saveShopping(Cart cart);

    List<Cart> queryShopping(String username, int begin, int end);

    int deleteShopping(String itemid, String userid);

    int updateQuantity(int quantity, String itemid, String userid);

    int queryCountShopping(String itemid, String userid);

    Cart queryOneShopping(String userid, String itemid);

    long count(String itemid, String userid);

    ShoppingDao getShoppingDao();

    void setShoppingDao(ShoppingDao shoppingDao);

}
