package com.wjf.bean;

import java.util.Date;

public class Shopping_cart {
    private int id;
    private int u_id;
    private int c_id;
    
    private int shop_count;
    private Date shop_time;
    private String shop_state;
    
   
	public String getShop_state() {
		return shop_state;
	}
	public void setShop_state(String shop_state) {
		this.shop_state = shop_state;
	}
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
}
