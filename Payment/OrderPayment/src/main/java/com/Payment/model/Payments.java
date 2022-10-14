package com.Payment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payments 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long pId;
	private Long cId;
	private Long oId;
	private Long price;
	public Payments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payments(Long pId, Long cId, Long oId, Long price) {
		super();
		this.pId = pId;
		this.cId = cId;
		this.oId = oId;
		this.price = price;
	}
	public Long getpId() {
		return pId;
	}
	public void setpId(Long pId) {
		this.pId = pId;
	}
	public Long getcId() {
		return cId;
	}
	public void setcId(Long cId) {
		this.cId = cId;
	}
	public Long getoId() {
		return oId;
	}
	public void setoId(Long oId) {
		this.oId = oId;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	
}
