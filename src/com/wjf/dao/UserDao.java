package com.wjf.dao;
import java.util.ArrayList;
import java.util.Iterator;  
import java.util.List;  
  








import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wjf.bean.Cycle;
import com.wjf.bean.User;
import com.wjf.util.HibernateSessionFactory;

public class UserDao {
	 private Session session;  
	    private Transaction tx;  
	      
	    public UserDao() {  
	       
	        session = HibernateSessionFactory.getSession();
	    }  
	      
	    /*  
	     * 将User对象插入到数据库中  
	     * @param user  
	     */  
	   
	      
	    
	    public void create(User user) {  
	        try {  
	            tx = session.beginTransaction();  
	            session.save(user);  
	            tx.commit();  
	        }   
	        finally {  
	        	  
	        }  
	    }  
	    public void update(User user) {  
	          
	        try {  
	        	tx = session.beginTransaction();  
		        session.update(user);  
		        tx.commit();  
		          
	        }   
	        finally {  
	        	
	        }  
	    }
	    public void delete(User user) {  
	          
	        try {  
	        	tx = session.beginTransaction();  
		        session.delete(user);  
		        tx.commit();  
		          
	        }   
	        finally {  
	        	
	        }  
	    }
	    public List<User> alluser(){
	    	try{
	    		tx = session.beginTransaction();
	    		List<User> all_user = new ArrayList<User>();
	    		String sql = "From User u";  
		        List list = session.createQuery(sql).list();  
		        Iterator it = list.iterator();  
		            while(it.hasNext()) { 
		            	User user = new User();
		            	user = (User)it.next();
		            	all_user.add(user);
		                 
		              } 
		            return all_user;
	    		
	    	}
	    	finally{
	    		
	    	}
	    }
	    public User ByID(int id) {  
	    	try{
	        tx = session.beginTransaction();  
	        User u = new User();
	        String sql = "From User u where u.id=" +id;  
	        List list = session.createQuery(sql).list();  
	        Iterator it = list.iterator();  
	            while(it.hasNext()) {  
	            	u = (User)it.next();
	            	System.out.print(u.getU_img());
	                return u;  
	              } 
	            
	            return u;
	       
	    	}finally{
	    		
	    	}
	       
	             
	    }  
	    public User findID(User user) {  
	    	try{
	        tx = session.beginTransaction();  
	        User u = new User();
	        String sql = "From User u where u.u_name='" +user.getU_name()+ "' and u.u_psswrd='"+user.getU_psswrd()+"'";  
	        List list = session.createQuery(sql).list();  
	        Iterator it = list.iterator();  
	            while(it.hasNext()) {  
	            	u = (User)it.next();
	            	System.out.print(u.getId());
	                return u;  
	              } 
	            
	            return u;
	       
	    	}finally{
	    		
	    	}
	       
	             
	    }  
	      
	    public boolean check(User user) {  
	    	try{
	        tx = session.beginTransaction();  
	        String sql = "select u.u_psswrd from User u where u.u_name='" +user.getU_name()+ "'";  
	        List list = session.createQuery(sql).list();  
	          
	            Iterator it = list.iterator();  
	            while(it.hasNext()) {  
	                String get = (String) it.next();  
	                System.out.println(get);  
	                if(get.equals(user.getU_psswrd())) {
	                return true;  
	                }  
	            }  
	           return false;     
	    } 
	    
	    finally{
	    	
	    }
	      
	    }   
	}  

