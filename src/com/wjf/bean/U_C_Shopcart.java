package com.wjf.bean;

import java.util.Date;

public class U_C_Shopcart {
	private int id;
    private int u_id;
    private int c_id;
    private String shop_img;
    private float shop_price;
    private int shop_count;
    private Date shop_time;
    private String shop_state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getShop_img() {
		return shop_img;
	}
	public void setShop_img(String shop_img) {
		this.shop_img = shop_img;
	}
	public float getShop_price() {
		return shop_price;
	}
	public void setShop_price(float shop_price) {
		this.shop_price = shop_price;
	}
	public int getShop_count() {
		return shop_count;
	}
	public void setShop_count(int shop_count) {
		this.shop_count = shop_count;
	}
	public Date getShop_time() {
		return shop_time;
	}
	public void setShop_time(Date shop_time) {
		this.shop_time = shop_time;
	}
	public String getShop_state() {
		return shop_state;
	}
	public void setShop_state(String shop_state) {
		this.shop_state = shop_state;
	}

}
