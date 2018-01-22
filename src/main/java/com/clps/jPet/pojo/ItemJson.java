package com.clps.jPet.pojo;

import java.io.Serializable;

public class ItemJson implements Serializable {

	private String itemid;
	private int supplier;
	private String productid;
	private double listprice;
	private double unitcost;
	private String status;
	private String attr1;
	private String attr2;
	private String attr3;
	private String attr4;
	private String attr5;

	public ItemJson(String itemid, int supplier, String productid, double listprice, double unitcost, String status,
			String attr1, String attr2, String attr3, String attr4, String attr5) {
		super();
		this.itemid = itemid;
		this.supplier = supplier;
		this.productid = productid;
		this.listprice = listprice;
		this.unitcost = unitcost;
		this.status = status;
		this.attr1 = attr1;
		this.attr2 = attr2;
		this.attr3 = attr3;
		this.attr4 = attr4;
		this.attr5 = attr5;
	}

	public String getItemid() {
		return itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public int getSupplier() {
		return supplier;
	}

	public void setSupplier(int supplier) {
		this.supplier = supplier;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public double getListprice() {
		return listprice;
	}

	public void setListprice(double listprice) {
		this.listprice = listprice;
	}

	public double getUnitcost() {
		return unitcost;
	}

	public void setUnitcost(double unitcost) {
		this.unitcost = unitcost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAttr1() {
		return attr1;
	}

	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}

	public String getAttr2() {
		return attr2;
	}

	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}

	public String getAttr3() {
		return attr3;
	}

	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}

	public String getAttr4() {
		return attr4;
	}

	public void setAttr4(String attr4) {
		this.attr4 = attr4;
	}

	public String getAttr5() {
		return attr5;
	}

	public void setAttr5(String attr5) {
		this.attr5 = attr5;
	}

	@Override
	public String toString() {
		return "ItemJson [itemid=" + itemid + ", supplier=" + supplier + ", productid=" + productid + ", listprice="
				+ listprice + ", unitcost=" + unitcost + ", status=" + status + ", attr1=" + attr1 + ", attr2=" + attr2
				+ ", attr3=" + attr3 + ", attr4=" + attr4 + ", attr5=" + attr5 + "]";
	}

}
