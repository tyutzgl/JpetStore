package com.clps.jPet.pojo;

/**
 * Bannerdata entity. @author MyEclipse Persistence Tools
 */

public class Bannerdata implements java.io.Serializable {

	// Fields

	private String favcategory;
	private String bannername;

	// Constructors

	/** default constructor */
	public Bannerdata() {
	}

	/** full constructor */
	public Bannerdata(String bannername) {
		this.bannername = bannername;
	}

	// Property accessors

	public String getFavcategory() {
		return this.favcategory;
	}

	public void setFavcategory(String favcategory) {
		this.favcategory = favcategory;
	}

	public String getBannername() {
		return this.bannername;
	}

	public void setBannername(String bannername) {
		this.bannername = bannername;
	}

}