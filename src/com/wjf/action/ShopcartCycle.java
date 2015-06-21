package com.wjf.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wjf.bean.Cycle;
import com.wjf.dao.CycleDao;

public class ShopcartCycle extends ActionSupport {
	private int c_id;
	private Map<String,Object> jsonMap;

	
	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}

	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	
	public String execute() throws Exception {
		
		CycleDao cycledao = new CycleDao();
		Cycle cycle = new Cycle();
		cycle = cycledao.ByID(c_id);
		jsonMap = new HashMap<String,Object>();
		String aaa = cycle.getC_img();
		System.out.print(aaa);
		jsonMap.put("cycle", cycle);  
	        // 放入一个是否操作成功的标识  
		jsonMap.put("success", true);  
	        // 返回结果  
	    return SUCCESS;  
		
	}
	

}
