package com.wjf.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wjf.bean.Manage;
import com.wjf.bean.User;
import com.wjf.util.HibernateSessionFactory;

public class ManageDao {
	private Session session;  
    private Transaction tx;  
    
    public ManageDao() {  
	       
        session = HibernateSessionFactory.getSession();
    }  
    public Manage findID(Manage manage) {  
    	try{
        tx = session.beginTransaction();  
        Manage m = new Manage();
        String sql = "From Manage m where m.m_name='" +manage.getM_name()+ "' and m.m_password='"+manage.getM_password()+"'";  
        List list = session.createQuery(sql).list();  
        Iterator it = list.iterator();  
            while(it.hasNext()) {  
            	m = (Manage)it.next();
            	System.out.print(m.getId());
                return m;  
              } 
            
            return m;
       
    	}finally{
    		
    	}
       
             
    }  
      
    public boolean check(Manage manage) {  
    	try{
        tx = session.beginTransaction();  
        String sql = "select m.m_password from Manage m where m.m_name='" +manage.getM_name()+ "'";  
        List list = session.createQuery(sql).list();  
          
            Iterator it = list.iterator();  
            while(it.hasNext()) {  
                String get = (String) it.next();  
                System.out.println(get);  
                if(get.equals(manage.getM_password())) {
                return true;  
                }  
            }  
           return false;     
    } 
    
    finally{
    	
    }
      
    }   

}
