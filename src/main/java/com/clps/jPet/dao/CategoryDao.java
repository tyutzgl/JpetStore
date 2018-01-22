package com.clps.jPet.dao;

import java.util.List;

import com.clps.jPet.pojo.Category;
import com.clps.jPet.pojo.Item;
import com.clps.jPet.pojo.Product;
import com.clps.jPet.pojo.Profile;


public interface CategoryDao {

    /**
     * Get product listings by category
     *
     * @param category
     * @param begin
     * @param end
     * @return List<Product>
     */
    List<Product> query(Category category, int begin, int end);

    /**
     * Get item listings by productId
     *
     * @param productid
     * @return List<Item>
     */
    List<Item> queryItem(String productid);

    /**
     * Get item inventory by itemId
     *
     * @param itemid
     * @return item inventory
     */
    long queryInventory(String itemid);

    /**
     * Get item bt itemId
     *
     * @param itemid
     * @return Item
     */
    Item queryItemTwo(String itemid);

    /**
     * Search for products based on simple information
     *
     * @param value
     * @param begin
     * @param end
     * @return List<Product>
     */
    List<Product> queryLike(String value, int begin, int end);

    /**
     * Get user's profile by userId
     *
     * @param userid
     * @return user's Profile
     */
    Profile queryProfile(String userid);

}
