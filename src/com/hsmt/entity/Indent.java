package com.hsmt.entity;

public class Indent {
	/* 数据库订单表的映射类 */
	private int order_id;
	private int product_id;
	private int order_amount;
	private int client_id;
	private String order_datedate;
	private String order_adress;

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getOrder_amount() {
		return order_amount;
	}

	public void setOrder_amount(int order_amount) {
		this.order_amount = order_amount;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getOrder_datedate() {
		return order_datedate;
	}

	public void setOrder_datedate(String order_datedate) {
		this.order_datedate = order_datedate;
	}

	public String getOrder_adress() {
		return order_adress;
	}

	public void setOrder_adress(String order_adress) {
		this.order_adress = order_adress;
	}

}
