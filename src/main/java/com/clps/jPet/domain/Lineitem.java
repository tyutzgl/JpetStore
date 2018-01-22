package com.clps.jPet.domain;

/**
 * Lineitem entity. @author MyEclipse Persistence Tools
 */

public class Lineitem implements java.io.Serializable {

	// Fields

	private LineitemId id;
	private String itemid;
	private Integer quantity;
	private double unitprice;

	// Constructors

	/** default constructor */
	public Lineitem() {
	}

	/** full constructor */
	public Lineitem(LineitemId id, String itemid, Integer quantity, double unitprice) {
		this.id = id;
		this.itemid = itemid;
		this.quantity = quantity;
		this.unitprice = unitprice;
	}

	// Property accessors

	public LineitemId getId() {
		return this.id;
	}

	public void setId(LineitemId id) {
		this.id = id;
	}

	public String getItemid() {
		return this.itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}

}