package com.clps.jPet.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clps.jPet.pojo.Account;
import com.clps.jPet.pojo.Inventory;
import com.clps.jPet.pojo.Lineitem;
import com.clps.jPet.pojo.Orders;
import com.clps.jPet.pojo.Orderstatus;


public interface OrderDao {

    /**
     * query account by user's id
     *
     * @param userid
     * @return
     */
    Account queryAccount(String userid);

    /**
     * save order
     *
     * @param orders
     */
    void saveOrder(Orders orders);

    /**
     * save item's line number
     *
     * @param lineitem
     */
    void saveLineitem(Lineitem lineitem);

    /**
     * save order's status
     *
     * @param orderstatus
     */
    void saveOrderstatus(Orderstatus orderstatus);

    /**
     * query order listings by user's id
     *
     * @param userid
     * @param begin
     * @param end
     * @return
     */
    List<Orders> queryOrder(String userid, int begin, int end);

    /**
     * Query order by order's id
     *
     * @param orderid
     * @return
     */
    Orders queryOrdersOne(int orderid);

    /**
     * Query inventory listings
     *
     * @return List<Inventory>
     */
    List<Inventory> queryInventory();

    /**
     * update item's inventory
     *
     * @param inventory
     */
    void updateInventory(Inventory inventory);

}
