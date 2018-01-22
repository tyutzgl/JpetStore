package com.clps.jPet.dao;

import java.util.List;

import com.clps.jPet.pojo.Cart;

public interface ShoppingDao {

    /**
     * Add items to shopping cart
     * @param cart
     */
    void saveShopping(Cart cart);

    /**
     * Query user's shopping cart by user's id
     * @param userid
     * @param begin
     * @param end
     * @return  List<Cart>
     */
    List<Cart> queryShopping(String userid, int begin, int end);

    /**
     * Remove the item from the shopping cart by item's id and user's id
     * @param itemid
     * @param userid
     * @return int>0 表示删除成功
     */
    int deleteShopping(String itemid, String userid);

    /**
     * update item's quantity
     * @param quantity
     * @param itemid
     * @param userid
     * @return
     */
    int updateQuantity(int quantity, String itemid, String userid);

    /**
     * Query user's shopping cart's item quantity
     * @param itemid
     * @param userid
     * @return item quantity
     */
    int queryCountShopping(String itemid, String userid);

    /**
     * query one item from user's shopping cart
     * @param userid
     * @param itemid
     * @return item
     */
    Cart queryOneShopping(String userid, String itemid);

    /**
     * query item's quantity from user's shopping cart
     * @param itemid
     * @param userid
     * @return item's quantity
     */
    long count(String itemid, String userid);
}
