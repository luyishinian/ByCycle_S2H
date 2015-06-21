package com.wjf.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wjf.bean.User;
import com.wjf.dao.UserDao;

public class DeleteUser extends ActionSupport{
	private int id;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String execute() throws Exception {
		User user = new User();
		UserDao userdao = new UserDao();
		System.out.print(id);
		user = userdao.ByID(id);
		userdao.delete(user);
		return SUCCESS;
	}

}
