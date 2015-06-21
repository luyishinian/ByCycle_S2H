package com.wjf.action;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.wjf.bean.Cycle;
import com.wjf.bean.Shopping_cart;
import com.wjf.bean.U_C_Shopcart;
import com.wjf.bean.User;
import com.wjf.dao.CycleDao;
import com.wjf.dao.Shopping_cartDao;
import com.wjf.dao.UserDao;

public class TestRegist extends ActionSupport{
	private String username;
	private String password;
	private String password2;
	
	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception {
		if(username == null || username.equals("") || password == null || password.equals("") || !password.equals(password2)){
			return ERROR;
	        }
		else{
		Date date = new Date();
		ActionContext ac = ActionContext.getContext();
		CycleDao cycleDao = new CycleDao();
		List<Cycle> all_cycle = new ArrayList<Cycle>();
		Shopping_cartDao shopcart = new Shopping_cartDao();
        List<U_C_Shopcart> user_shopcart = new ArrayList<U_C_Shopcart>();
		UserDao userDao = new UserDao();  
        User user = new User();  
        user.setU_name(username);  
        user.setU_psswrd(password);
        user.setU_img("img/user.jpg");
        user.setU_sex("NULL");
        user.setU_birth(date);
        user.setU_regist_time(date);
        user.setU_lastlogin_time(date);
        
        
            userDao.create(user);
            user_shopcart = shopcart.allfind_p_c(user.getId());
            all_cycle = cycleDao.findAll();
           
            ac.put("login", user);
		    ac.getSession().put("login", user);
		    ac.put("cycle", all_cycle);
			ac.getSession().put("cycle", all_cycle);
			ac.put("shopcart", user_shopcart);
			ac.getSession().put("shopcart", user_shopcart);
		    return SUCCESS;
		    }
        
	}
	

}
