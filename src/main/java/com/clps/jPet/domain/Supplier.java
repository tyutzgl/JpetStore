package com.clps.jPet.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Supplier entity. @author MyEclipse Persistence Tools
 */

public class Supplier implements java.io.Serializable {

	// Fields

	private Integer suppid;
	private String name;
	private String status;
	private String addr1;
	private String addr2;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private Set items = new HashSet(0);
	private Set items_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Supplier() {
	}

	/** minimal constructor */
	public Supplier(String status) {
		this.status = status;
	}

	/** full constructor */
	public Supplier(String name, String status, String addr1, String addr2, String city, String state, String zip,
			String phone, Set items, Set items_1) {
		this.name = name;
		this.status = status;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.items = items;
		this.items_1 = items_1;
	}

	// Property accessors

	public Integer getSuppid() {
		return this.suppid;
	}

	public void setSuppid(Integer suppid) {
		this.suppid = suppid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddr1() {
		return this.addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return this.addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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