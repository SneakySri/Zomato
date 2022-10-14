package com.Payment.model;

public class Orders 
{
	private String productname;
	private Long productprice;
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(String productname, Long productprice, String productweight) {
		super();
		this.productname = productname;
		this.productprice = productprice;
		
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
