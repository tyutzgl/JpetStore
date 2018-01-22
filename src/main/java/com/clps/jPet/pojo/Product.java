package com.clps.jPet.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	// Fields

	private String productid;
	private Category category;
	private String name;
	private String descn;
	private Set items = new HashSet(0);
	private Set items_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
	public Product(Category category) {
		this.category = category;
	}

	/** full constructor */
	public Product(Category category, String name, String descn, Set items, Set items_1) {
		this.category = category;
		this.name = name;
		this.descn = descn;
		this.items = items;
		this.items_1 = items_1;
	}

	// Property accessors

	public String getProductid() {
		return this.productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescn() {
		return this.descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}

	public Set getItems() {
		return this.items;
	}

	public void setItems(Set items) {
		this.items = items;
	}

	public Set getItems_1() {
		return this.items_1;
	}

	public void setItems_1(Set items_1) {
		this.items_1 = items_1;
	}

}