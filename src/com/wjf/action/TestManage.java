package com.wjf.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wjf.bean.Cycle;
import com.wjf.bean.Manage;
import com.wjf.bean.User;
import com.wjf.dao.CycleDao;
import com.wjf.dao.ManageDao;
import com.wjf.dao.UserDao;

public class TestManage extends ActionSupport{
	 
    private String manage;  
    private String password;
	public String getManage() {
		return manage;
	}
	public void setManage(String manage) {
		this.manage = manage;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 public String execute() throws Exception {  
		 ActionContext ac = ActionContext.getContext();
		 ManageDao managedao = new ManageDao();
		 UserDao userdao = new UserDao();
		 CycleDao cycleDao = new CycleDao();
		 List<User> all_user = new ArrayList<User>();
		 List<Cycle> all_cycle = new ArrayList<Cycle>();
		 Manage m = new Manage();
		 Manage manageId = new Manage();
		 
		 m.setM_name(manage);
		 m.setM_password(password);
		 if(managedao.check(m)){
			 manageId = managedao.findID(m);
			 all_user = userdao.alluser();
			 all_cycle = cycleDao.findAll();
			 ac.put("all_cycle", all_cycle);
			 ac.getSession().put("all_cycle", all_cycle);
			 ac.put("manage", manageId);
			 ac.getSession().put("manage", manageId);
			 ac.put("all_user", all_user);
			 ac.getSession().put("all_user", all_user);
			 return SUCCESS;
		 }
		 return ERROR;
		 
		 
		 
	 }
    
}
