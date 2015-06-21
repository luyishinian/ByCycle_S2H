package com.wjf.action;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wjf.bean.Shopping_cart;
import com.wjf.bean.U_C_Shopcart;
import com.wjf.dao.Shopping_cartDao;

public class ShoppingCart extends ActionSupport{
	private int u_id;
	private int c_id;
	private int count;
	private String shop_img;
	private float shop_price;
	private Map<String,Object> dataMap;
	
	
	


	public Map<String, Object> getDataMap() {
		return dataMap;
	}


	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
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


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public String execute() throws Exception {
		Date date = new Date();
		String state = "Î´¸¶¿î";
		ActionContext ac = ActionContext.getContext();
		Shopping_cartDao shopcartdao = new Shopping_cartDao();
		Shopping_cart shopcart = new Shopping_cart();
		U_C_Shopcart ucs = new U_C_Shopcart();
		shopcart.setC_id(c_id);
		shopcart.setU_id(u_id);
		shopcart.setShop_count(count);
		shopcart.setShop_time(date);
		shopcart.setShop_state(state);
		
		shopcartdao.create(shopcart);
		ucs = shopcartdao.find_p_c(shopcart);
		dataMap = new HashMap<String,Object>();
		dataMap.put("new_shopcart", ucs);
		dataMap.put("success", true);
		ac.put("shopcart", ucs);
		ac.getSession().put("shopcart",ucs);
		
		return SUCCESS;
	}

}
