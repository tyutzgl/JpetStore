package com.clps.jPet.pojo;

import java.util.Date;

/**
 * Orderstatus entity. @author MyEclipse Persistence Tools
 */

public class Orderstatus implements java.io.Serializable {

	// Fields

	private OrderstatusId id;
	private Date timestamp;
	private String status;

	// Constructors

	/** default constructor */
	public Orderstatus() {
	}

	/** full constructor */
	public Orderstatus(OrderstatusId id, Date timestamp, String status) {
		this.id = id;
		this.timestamp = timestamp;
		this.status = status;
	}

	// Property accessors

	public OrderstatusId getId() {
		return this.id;
	}

	public void setId(OrderstatusId id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}