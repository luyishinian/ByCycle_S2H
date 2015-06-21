package com.wjf.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wjf.bean.Order;
import com.wjf.util.HibernateSessionFactory;

public class OrderDao {
	private Session session;  
    private Transaction tx; 
    
    public OrderDao(){
    	session = HibernateSessionFactory.getSession();
    }
    
    public void create(Order order){
    	try{
    		tx = session.beginTransaction();
    		session.save(order);
    		tx.commit();
    	}
    	finally{
    		HibernateSessionFactory.closeSession();
    	}
    	
    }
    
    public void update(Order order){
    	try{
    		tx = session.beginTransaction();
    		session.update(order);
    		tx.commit();
    	}
    	finally{
    		HibernateSessionFactory.closeSession();
    	}
    	
    }
    
    public List<Order> ByUser(int u_id){
    	try{
    		tx = session.beginTransaction();
    		List<Order> user_order = new ArrayList<Order>();
    		String sql = "From Order o where o.u_id=" +u_id;
    		List list = session.createQuery(sql).list();
    		Iterator it = list.iterator();
    		while(it.hasNext()){
    			Order order = new Order();
    			order = (Order)it.next();
    			user_order.add(order);
    		}
    		
    		return user_order;
    		
    	}finally{
    		
    	}
    }
    
    

}
