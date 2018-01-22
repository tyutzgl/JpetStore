package com.clps.jPet.domain;

/**
 * Sequence entity. @author MyEclipse Persistence Tools
 */

public class Sequence implements java.io.Serializable {

	// Fields

	private String name;
	private Integer nextid;

	// Constructors

	/** default constructor */
	public Sequence() {
	}

	/** full constructor */
	public Sequence(Integer nextid) {
		this.nextid = nextid;
	}

	// Property accessors

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNextid() {
		return this.nextid;
	}

	public void setNextid(Integer nextid) {
		this.nextid = nextid;
	}

}