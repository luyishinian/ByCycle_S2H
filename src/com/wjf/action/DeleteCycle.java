package com.wjf.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wjf.bean.Cycle;
import com.wjf.dao.CycleDao;

public class DeleteCycle extends ActionSupport{
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String execute() throws Exception{
		CycleDao cycledao = new CycleDao();
		Cycle cycle = new Cycle();
		cycle = cycledao.ByID(id);
		cycledao.delete(cycle);
		return SUCCESS;
	}

}
