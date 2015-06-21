

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
public class TestLogin extends ActionSupport {  
	  
    private int id;  
    private String username;  
    private String password;  
      
    
    public String execute() throws Exception {  
    	Date date = new Date();
    	ActionContext ac = ActionContext.getContext();
        UserDao userDao = new UserDao();
        CycleDao cycleDao = new CycleDao();
        Shopping_cartDao shopcart = new Shopping_cartDao();
        List<U_C_Shopcart> user_shopcart = new ArrayList<U_C_Shopcart>();
        List<Cycle> all_cycle = new ArrayList<Cycle>();
       
        User user = new User();  
        User userID = new User();
        user.setU_name(username);  
        user.setU_psswrd(password); 
        
        if(userDao.check(user)) {  
        	all_cycle = cycleDao.findAll();
        	userID = userDao.findID(user);
        	userID.setU_lastlogin_time(date);
        	userDao.update(userID);
        	user_shopcart = shopcart.allfind_p_c(userID.getId());
        	
        	ac.put("login", userID);
			ac.getSession().put("login", userID);
			ac.put("cycle", all_cycle);
			ac.getSession().put("cycle", all_cycle);
			ac.put("shopcart", user_shopcart);
			ac.getSession().put("shopcart", user_shopcart);
			
            return SUCCESS; 
            
        }  
        return ERROR;  
    }  
  
    public int getId() {  
        return id;  
    }  
  
    public void setId(int id) {  
        this.id = id;  
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
      
}  

