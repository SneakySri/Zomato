package com.Payment.model;

public class Customer 
{
	private Long cId;
	private String cname;
	private String caddress;
	private String cmobile;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(Long cId, String cname, String caddress, String cmobile) {
		super();
		this.cId = cId;
		this.cname = cname;
		this.caddress = caddress;
		this.cmobile = cmobile;
	}
	public Long getcId() {
		return cId;
	}
	public void setcId(Long cId) {
		this.cId = cId;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public String getCmobile() {
		return cmobile;
	}
	public void setCmobile(String cmobile) {
		this.cmobile = cmobile;
	}
	
}
