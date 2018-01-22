package com.clps.jPet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.jPet.dao.ShoppingDao;
import com.clps.jPet.pojo.Cart;

public interface ShoppingService {
    /**
     * Add items to shopping cart
     *
     * @param cart
     */
    void saveShopping(Cart cart);

    /**
     * Query user's shopping cart by user's id
     *
     * @param username
     * @param begin
     * @param end
     * @return List<Cart>
     */
    List<Cart> queryShopping(String username, int begin, int end);

    /**
     * Remove the item from the shopping cart by item's id and user's id
     *
     * @param itemid
     * @param userid
     * @return int>0 表示删除成功
     */
    int deleteShopping(String itemid, String userid);

    /**
     * update item's quantity
     *
     * @param quantity
     * @param itemid
     * @param userid
     * @return
     */
    int updateQuantity(int quantity, String itemid, String userid);

    /**
     * Query user's shopping cart's item quantity
     *
     * @param itemid
     * @param userid
     * @return item quantity
     */
    int queryCountShopping(String itemid, String userid);

    /**
     * query one item from user's shopping cart
     *
     * @param userid
     * @param itemid
     * @return item
     */
    Cart queryOneShopping(String userid, String itemid);

    /**
     * query item's quantity from user's shopping cart
     *
     * @param itemid
     * @param userid
     * @return item's quantity
     */
    long count(String itemid, String userid);


}
