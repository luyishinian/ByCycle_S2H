package com.wjf.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wjf.bean.Shopping_cart;
import com.wjf.dao.Shopping_cartDao;

public class DeleteShopcart extends ActionSupport{
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String execute() throws Exception{
		Shopping_cartDao shopcartdao = new Shopping_cartDao();
		Shopping_cart shopcart = new Shopping_cart();
		shopcart = shopcartdao.ByCart(id);
		shopcartdao.delete(shopcart);
		return SUCCESS;
	}

}
