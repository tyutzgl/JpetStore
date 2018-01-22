package com.clps.jPet.pojo;

/**
 * Profile entity. @author MyEclipse Persistence Tools
 */

public class Profile implements java.io.Serializable {

	// Fields

	private String userid;
	private String langpref;
	private String favcategory;
	private Integer mylistopt;
	private Integer banneropt;
	private Integer id;

	// Constructors

	/** default constructor */
	public Profile() {
	}

	/** minimal constructor */
	public Profile(String userid, String langpref) {
		this.userid = userid;
		this.langpref = langpref;
	}

	/** full constructor */
	public Profile(String userid, String langpref, String favcategory, Integer mylistopt, Integer banneropt,
			Integer id) {
		this.userid = userid;
		this.langpref = langpref;
		this.favcategory = favcategory;
		this.mylistopt = mylistopt;
		this.banneropt = banneropt;
		this.id = id;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getLangpref() {
		return this.langpref;
	}

	public void setLangpref(String langpref) {
		this.langpref = langpref;
	}

	public String getFavcategory() {
		return this.favcategory;
	}

	public void setFavcategory(String favcategory) {
		this.favcategory = favcategory;
	}

	public Integer getMylistopt() {
		return this.mylistopt;
	}

	public void setMylistopt(Integer mylistopt) {
		this.mylistopt = mylistopt;
	}

	public Integer getBanneropt() {
		return this.banneropt;
	}

	public void setBanneropt(Integer banneropt) {
		this.banneropt = banneropt;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}