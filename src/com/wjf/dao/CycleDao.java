package com.wjf.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wjf.bean.Cycle;
import com.wjf.bean.User;
import com.wjf.util.HibernateSessionFactory;

public class CycleDao {
	 private Session session;  
	    private Transaction tx;  
	      
	    public CycleDao() {  
	       
	        session = HibernateSessionFactory.getSession();
	    }  
	    public void create(Cycle cycle) {  
	        try {  
	            tx = session.beginTransaction();  
	            session.save(cycle);  
	            tx.commit();  
	        }   
	        finally {  
	        	  
	        }  
	    }  
	    public void update(Cycle cycle) {  
	          
	        try {  
	        	tx = session.beginTransaction();  
		        session.update(cycle);  
		        tx.commit();  
		          
	        }   
	        finally {  
	        	
	        }  
	    }
	    
	    public void delete(Cycle cycle) {  
	          
	        try {  
	        	tx = session.beginTransaction();  
		        session.delete(cycle);  
		        tx.commit();  
		          
	        }   
	        finally {  
	        	
	        }  
	    }
	    public List<Cycle> findAll() {  
	    	try{
	        tx = session.beginTransaction(); 
	        
	        List<Cycle> all_cycle = new ArrayList<Cycle>();
	        String sql = "From Cycle c";  
	        List list = session.createQuery(sql).list();  
	        Iterator it = list.iterator();  
	            while(it.hasNext()) { 
	            	Cycle cycle = new Cycle();
	            	cycle = (Cycle)it.next();
	            	all_cycle.add(cycle);
	                 
	              } 
	            
	            return all_cycle;
	       
	    	}finally{
	    		
	    	}
	       
	             
	    }  
	    
	    public Cycle ByID(int id) {  
	    	try{
	        tx = session.beginTransaction();  
	        Cycle c = new Cycle();
	        String sql = "From Cycle c where c.id=" +id;  
	        List list = session.createQuery(sql).list();  
	        Iterator it = list.iterator();  
	            while(it.hasNext()) {  
	            	c = (Cycle)it.next();
	            	System.out.print(c.getC_img());
	                return c;  
	              } 
	            
	            return c;
	       
	    	}finally{
	    		
	    	}
	       
	             
	    }  

}
