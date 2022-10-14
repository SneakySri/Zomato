package com.Order.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orders 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	private String productname;
	private Long productprice;
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(Long oId, String productname, Long productprice, String productweight) {
		super();
		this.Id = oId;
		this.productname = productname;
		this.productprice = productprice;
		
	}
	public Long getId() {
		return Id;
	}
	public void setoId(Long Id) {
		this.Id = Id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public Long getProductprice() {
		return productprice;
	}
	public void setProductprice(Long productprice) {
		this.productprice = productprice;
	}
	
}
