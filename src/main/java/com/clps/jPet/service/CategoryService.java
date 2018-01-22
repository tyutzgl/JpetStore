package com.clps.jPet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.jPet.dao.CategoryDao;
import com.clps.jPet.pojo.Category;
import com.clps.jPet.pojo.Item;
import com.clps.jPet.pojo.Product;
import com.clps.jPet.pojo.Profile;

public interface CategoryService {

    List<Product> query(Category category, int begin, int end);

    List<Item> queryItem(String productid);

    Profile queryProfile(String username);

    long queryInventory(String itemid);

    Item queryItemTwo(String itemid);

    List<Product> queryLike(String value, int begin, int end);

    CategoryDao getCategoryDao();

    void setCategoryDao(CategoryDao categoryDao);

}
