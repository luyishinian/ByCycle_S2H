package com.wjf.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wjf.bean.Cycle;
import com.wjf.bean.Shopping_cart;
import com.wjf.bean.U_C_Shopcart;
import com.wjf.util.HibernateSessionFactory;

public class Shopping_cartDao {
	private Session session;  
    private Transaction tx; 
    
    public Shopping_cartDao() {  
	       
        session = HibernateSessionFactory.getSession();
    } 
    
    public void create(Shopping_cart shopcart){
    	try{
    		tx = session.beginTransaction();
    		
    		session.save(shopcart);
    		tx.commit();
    		
    	}
    	finally{
    		
    	}
    	
    }
    public void delete(Shopping_cart shopcart){
    	try{
    		tx = session.beginTransaction();
    		
    		session.delete(shopcart);
    		tx.commit();
    		
    	}
    	finally{
    		
    	}
    	
    }
    public void update(Shopping_cart shopcart){
    	try{
    		tx = session.beginTransaction();
    		session.update(shopcart);
    		tx.commit();
    		
    	}
    	finally{
    		HibernateSessionFactory.closeSession();
    	}
    	
    }
    public List<U_C_Shopcart> allfind_p_c(int u_id){
    	try{
    		tx = session.beginTransaction();
    		List<U_C_Shopcart> user_shopcart = new ArrayList<U_C_Shopcart>();
    		
    		String sql = "From Shopping_cart s where s.u_id=" +u_id;
    		List list = session.createQuery(sql).list(); 
    		Iterator it = list.iterator();
    		while(it.hasNext()){
    			Shopping_cart shopcart = new Shopping_cart();
    			U_C_Shopcart ucs = new U_C_Shopcart();
    			shopcart = (Shopping_cart)it.next();
    			ucs = find_p_c(shopcart);
    			user_shopcart.add(ucs);
    			
    		}
    		
    		return user_shopcart;
    	}
    	finally{
    		
    	}
    	
    }
    public U_C_Shopcart find_p_c(Shopping_cart shop_cart){
    	try{
    		tx = session.beginTransaction();
    		U_C_Shopcart ucs = new U_C_Shopcart();
    		String sql = "From Cycle c where c.id=" +shop_cart.getC_id();
    		List list = session.createQuery(sql).list(); 
    		Iterator it = list.iterator();
    		while(it.hasNext()){
    			Cycle cycle = new Cycle();
    			cycle = (Cycle)it.next();
    			ucs.setId(shop_cart.getId());
    			ucs.setShop_count(shop_cart.getShop_count());
    			ucs.setU_id(shop_cart.getU_id());
    			ucs.setId(shop_cart.getId());
    			ucs.setShop_state(shop_cart.getShop_state());
    			ucs.setShop_time(shop_cart.getShop_time());
    			ucs.setShop_img(cycle.getC_img());
    			ucs.setShop_price(cycle.getC_price());
    		}
    		return ucs;
    	}finally{
    		
    	}
    	
    }
    public List<Shopping_cart> ByUser(int u_id){
    	try{
    		tx = session.beginTransaction();
    		List<Shopping_cart> user_shopcart = new ArrayList<Shopping_cart>();
    		String sql = "From Shopping_cart s where s.u_id=" +u_id;
    		List list = session.createQuery(sql).list(); 
    		Iterator it = list.iterator();
    		while(it.hasNext()){
    			Shopping_cart shopcart = new Shopping_cart();
    			shopcart = (Shopping_cart)it.next();
    			user_shopcart.add(shopcart);
    		}
    		
    		return user_shopcart;
    	}
    	finally{
    		
    	}
    	
    	
    }
    public Shopping_cart ByCart(int id){
    	try{
    		tx = session.beginTransaction();
    		Shopping_cart shopcart = new Shopping_cart();
    		String sql ="From Shopping_cart s where s.id=" +id;
    		List list = session.createQuery(sql).list(); 
    		Iterator it = list.iterator();
    		while(it.hasNext()){
    			shopcart = (Shopping_cart)it.next();
    			
    		}
    		return shopcart;
    	}finally{
    		
    	}
    }
    public List<Cycle> ByCycle(int u_id){
    	try{
    		tx = session.beginTransaction();
    		CycleDao cycledao = new CycleDao();
    		List<Cycle> shopcart_cycle = new ArrayList<Cycle>();
    		String sql = "From Shopping_cart s where s.u_id=" +u_id;
    		List list = session.createQuery(sql).list(); 
    		Iterator it = list.iterator();
    		while(it.hasNext()){
    			Shopping_cart shopcart = new Shopping_cart();
    			Cycle cycle = new Cycle();
    			shopcart = (Shopping_cart)it.next();
    			cycle = cycledao.ByID(shopcart.getC_id());
    			shopcart_cycle.add(cycle);
    		}
    		
    		return shopcart_cycle;
    	}
    	finally{
    		
    	}
    	
    	
    }
    

}
