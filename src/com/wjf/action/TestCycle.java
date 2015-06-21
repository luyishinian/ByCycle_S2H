package com.wjf.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wjf.bean.Cycle;
import com.wjf.dao.CycleDao;

public class TestCycle extends ActionSupport{
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String execute() throws Exception {
		ActionContext ac = ActionContext.getContext();
		CycleDao cycleDao = new CycleDao();
		Cycle cycle =  new Cycle();
		cycle = cycleDao.ByID(id);
		ac.put("c_show", cycle);
		ac.getSession().put("c_show", cycle);
		return SUCCESS;
	}

}
