package com.clps.jPet.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */

public class Category implements java.io.Serializable {

	// Fields

	private String catid;
	private String name;
	private String descn;
	private Set products = new HashSet(0);
	private Set products_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** full constructor */
	public Category(String name, String descn, Set products, Set products_1) {
		this.name = name;
		this.descn = descn;
		this.products = products;
		this.products_1 = products_1;
	}

	// Property accessors

	public String getCatid() {
		return this.catid;
	}

	public void setCatid(String catid) {
		this.catid = catid;
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

	public Set getProducts() {
		return this.products;
	}

	public void setProducts(Set products) {
		this.products = products;
	}

	public Set getProducts_1() {
		return this.products_1;
	}

	public void setProducts_1(Set products_1) {
		this.products_1 = products_1;
	}

}