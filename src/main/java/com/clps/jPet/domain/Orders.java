package com.clps.jPet.domain;

import java.util.Date;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	private Integer orderid;
	private String userid;
	private Date orderdate;
	private String shipaddr1;
	private String shipaddr2;
	private String shipcity;
	private String shipstate;
	private String shipzip;
	private String shipcountry;
	private String billaddr1;
	private String billaddr2;
	private String billcity;
	private String billstate;
	private String billzip;
	private String billcountry;
	private String courier;
	private double totalprice;
	private String billtofirstname;
	private String billtolastname;
	private String shiptofirstname;
	private String shiptolastname;
	private String creditcard;
	private String exprdate;
	private String cardtype;
	private String locale;

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** minimal constructor */
	public Orders(String userid, Date orderdate, String shipaddr1, String shipcity, String shipstate, String shipzip,
			String shipcountry, String billaddr1, String billcity, String billstate, String billzip, String billcountry,
			String courier, double totalprice, String billtofirstname, String billtolastname, String shiptofirstname,
			String shiptolastname, String creditcard, String exprdate, String cardtype, String locale) {
		this.userid = userid;
		this.orderdate = orderdate;
		this.shipaddr1 = shipaddr1;
		this.shipcity = shipcity;
		this.shipstate = shipstate;
		this.shipzip = shipzip;
		this.shipcountry = shipcountry;
		this.billaddr1 = billaddr1;
		this.billcity = billcity;
		this.billstate = billstate;
		this.billzip = billzip;
		this.billcountry = billcountry;
		this.courier = courier;
		this.totalprice = totalprice;
		this.billtofirstname = billtofirstname;
		this.billtolastname = billtolastname;
		this.shiptofirstname = shiptofirstname;
		this.shiptolastname = shiptolastname;
		this.creditcard = creditcard;
		this.exprdate = exprdate;
		this.cardtype = cardtype;
		this.locale = locale;
	}

	/** full constructor */
	public Orders(String userid, Date orderdate, String shipaddr1, String shipaddr2, String shipcity, String shipstate,
			String shipzip, String shipcountry, String billaddr1, String billaddr2, String billcity, String billstate,
			String billzip, String billcountry, String courier, double totalprice, String billtofirstname,
			String billtolastname, String shiptofirstname, String shiptolastname, String creditcard, String exprdate,
			String cardtype, String locale) {
		this.userid = userid;
		this.orderdate = orderdate;
		this.shipaddr1 = shipaddr1;
		this.shipaddr2 = shipaddr2;
		this.shipcity = shipcity;
		this.shipstate = shipstate;
		this.shipzip = shipzip;
		this.shipcountry = shipcountry;
		this.billaddr1 = billaddr1;
		this.billaddr2 = billaddr2;
		this.billcity = billcity;
		this.billstate = billstate;
		this.billzip = billzip;
		this.billcountry = billcountry;
		this.courier = courier;
		this.totalprice = totalprice;
		this.billtofirstname = billtofirstname;
		this.billtolastname = billtolastname;
		this.shiptofirstname = shiptofirstname;
		this.shiptolastname = shiptolastname;
		this.creditcard = creditcard;
		this.exprdate = exprdate;
		this.cardtype = cardtype;
		this.locale = locale;
	}

	// Property accessors

	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public String getShipaddr1() {
		return this.shipaddr1;
	}

	public void setShipaddr1(String shipaddr1) {
		this.shipaddr1 = shipaddr1;
	}

	public String getShipaddr2() {
		return this.shipaddr2;
	}

	public void setShipaddr2(String shipaddr2) {
		this.shipaddr2 = shipaddr2;
	}

	public String getShipcity() {
		return this.shipcity;
	}

	public void setShipcity(String shipcity) {
		this.shipcity = shipcity;
	}

	public String getShipstate() {
		return this.shipstate;
	}

	public void setShipstate(String shipstate) {
		this.shipstate = shipstate;
	}

	public String getShipzip() {
		return this.shipzip;
	}

	public void setShipzip(String shipzip) {
		this.shipzip = shipzip;
	}

	public String getShipcountry() {
		return this.shipcountry;
	}

	public void setShipcountry(String shipcountry) {
		this.shipcountry = shipcountry;
	}

	public String getBilladdr1() {
		return this.billaddr1;
	}

	public void setBilladdr1(String billaddr1) {
		this.billaddr1 = billaddr1;
	}

	public String getBilladdr2() {
		return this.billaddr2;
	}

	public void setBilladdr2(String billaddr2) {
		this.billaddr2 = billaddr2;
	}

	public String getBillcity() {
		return this.billcity;
	}

	public void setBillcity(String billcity) {
		this.billcity = billcity;
	}

	public String getBillstate() {
		return this.billstate;
	}

	public void setBillstate(String billstate) {
		this.billstate = billstate;
	}

	public String getBillzip() {
		return this.billzip;
	}

	public void setBillzip(String billzip) {
		this.billzip = billzip;
	}

	public String getBillcountry() {
		return this.billcountry;
	}

	public void setBillcountry(String billcountry) {
		this.billcountry = billcountry;
	}

	public String getCourier() {
		return this.courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}

	public double getTotalprice() {
		return this.totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public String getBilltofirstname() {
		return this.billtofirstname;
	}

	public void setBilltofirstname(String billtofirstname) {
		this.billtofirstname = billtofirstname;
	}

	public String getBilltolastname() {
		return this.billtolastname;
	}

	public void setBilltolastname(String billtolastname) {
		this.billtolastname = billtolastname;
	}

	public String getShiptofirstname() {
		return this.shiptofirstname;
	}

	public void setShiptofirstname(String shiptofirstname) {
		this.shiptofirstname = shiptofirstname;
	}

	public String getShiptolastname() {
		return this.shiptolastname;
	}

	public void setShiptolastname(String shiptolastname) {
		this.shiptolastname = shiptolastname;
	}

	public String getCreditcard() {
		return this.creditcard;
	}

	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}

	public String getExprdate() {
		return this.exprdate;
	}

	public void setExprdate(String exprdate) {
		this.exprdate = exprdate;
	}

	public String getCardtype() {
		return this.cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getLocale() {
		return this.locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	@Override
	public String toString() {
		return "Orders [orderid=" + orderid + ", userid=" + userid + ", orderdate=" + orderdate + ", shipaddr1="
				+ shipaddr1 + ", shipaddr2=" + shipaddr2 + ", shipcity=" + shipcity + ", shipstate=" + shipstate
				+ ", shipzip=" + shipzip + ", shipcountry=" + shipcountry + ", billaddr1=" + billaddr1 + ", billaddr2="
				+ billaddr2 + ", billcity=" + billcity + ", billstate=" + billstate + ", billzip=" + billzip
				+ ", billcountry=" + billcountry + ", courier=" + courier + ", totalprice=" + totalprice
				+ ", billtofirstname=" + billtofirstname + ", billtolastname=" + billtolastname + ", shiptofirstname="
				+ shiptofirstname + ", shiptolastname=" + shiptolastname + ", creditcard=" + creditcard + ", exprdate="
				+ exprdate + ", cardtype=" + cardtype + ", locale=" + locale + "]";
	}

}