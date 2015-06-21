package com.wjf.action;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.wjf.bean.Cycle;
import com.wjf.dao.CycleDao;

public class CreateCycle extends ActionSupport{
	private String title;
	private String message;
	private String address;
	private int count;
	private float price;
	private Map<String,Object> dataMap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDateMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String execute() throws Exception{
		CycleDao cycledao = new CycleDao();
		Cycle cycle = new Cycle();
		cycle.setC_name(title);
	    cycle.setC_message(message);
	    cycle.setC_address(address);
	    cycle.setC_img("img/cycle.jpg");
	    cycle.setC_price(price);
	    cycle.setC_count(count);
	    cycle.setC_collect(0);
	    cycledao.create(cycle);
	    dataMap = new HashMap<String,Object>();
	    dataMap.put("new_cycle", cycle);
	    dataMap.put("success", true);
		return SUCCESS;
		
	}

}
