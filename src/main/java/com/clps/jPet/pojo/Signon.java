package com.clps.jPet.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Signon entity. @author MyEclipse Persistence Tools
 */

public class Signon implements java.io.Serializable {

	// Fields

	private String username;
	private String password;
	private Set carts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Signon() {
	}

	/** minimal constructor */
	public Signon(String password) {
		this.password = password;
	}
	

	public Signon(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public Signon(String password, Set carts) {
		this.password = password;
		this.carts = carts;
	}

	// Property accessors

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set getCarts() {
		return this.carts;
	}

	public void setCarts(Set carts) {
		this.carts = carts;
	}

}