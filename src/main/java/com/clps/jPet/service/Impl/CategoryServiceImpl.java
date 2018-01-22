package com.clps.jPet.service.Impl;

import com.clps.jPet.dao.CategoryDao;
import com.clps.jPet.pojo.Category;
import com.clps.jPet.pojo.Item;
import com.clps.jPet.pojo.Product;
import com.clps.jPet.pojo.Profile;
import com.clps.jPet.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;

	public List<Product> query(Category category, int begin, int end) {

		return categoryDao.query(category, begin, end);
	}

	public List<Item> queryItem(String productid) {
		// TODO Auto-generated method stub
		return categoryDao.queryItem(productid);
	}

	public Profile queryProfile(String username) {
		// TODO Auto-generated method stub
		return categoryDao.queryProfile(username);
	}

	public long queryInventory(String itemid) {

		return categoryDao.queryInventory(itemid);
	}

	public Item queryItemTwo(String itemid) {

		return categoryDao.queryItemTwo(itemid);
	}

	public List<Product> queryLike(String value, int begin, int end) {

		return categoryDao.queryLike(value, begin, end);
	}

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

}
