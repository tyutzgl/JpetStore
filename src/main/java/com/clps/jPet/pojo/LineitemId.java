package com.clps.jPet.pojo;

/**
 * LineitemId entity. @author MyEclipse Persistence Tools
 */

public class LineitemId implements java.io.Serializable {

	// Fields

	private Integer orderid;
	private Integer linenum;

	// Constructors

	/** default constructor */
	public LineitemId() {
	}

	/** full constructor */
	public LineitemId(Integer orderid, Integer linenum) {
		this.orderid = orderid;
		this.linenum = linenum;
	}

	// Property accessors

	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Integer getLinenum() {
		return this.linenum;
	}

	public void setLinenum(Integer linenum) {
		this.linenum = linenum;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LineitemId))
			return false;
		LineitemId castOther = (LineitemId) other;

		return ((this.getOrderid() == castOther.getOrderid()) || (this.getOrderid() != null
				&& castOther.getOrderid() != null && this.getOrderid().equals(castOther.getOrderid())))
				&& ((this.getLinenum() == castOther.getLinenum()) || (this.getLinenum() != null
						&& castOther.getLinenum() != null && this.getLinenum().equals(castOther.getLinenum())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getOrderid() == null ? 0 : this.getOrderid().hashCode());
		result = 37 * result + (getLinenum() == null ? 0 : this.getLinenum().hashCode());
		return result;
	}

}