package com.cts;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
public class App 
{  public static void main( String[] args )
    {   System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        //create
        Stock stock = new Stock();
        stock.setStockCode("001-T");
        stock.setStockName("Tab");
        session.save(stock);
        session.getTransaction().commit();
        
        //get
        Stock stock1=(Stock)session.load(Stock.class, 1);
        
        System.out.println(stock1);
        /*
        
      //update
        session.beginTransaction();
        Stock stock3=(Stock)session.load(Stock.class, 1);
        stock3.setStockName("XXXX");
        session.getTransaction().commit();
        
        //delete
      /*  session.beginTransaction();
        
        Stock stock2=(Stock)session.load(Stock.class, 1);
        session.delete(stock2);
        session.getTransaction().commit();
      */
        
         Query q=session.createQuery("from Stock s");  //HQL
        List<Stock>stocklist=q.list();
        for(Stock s:stocklist)
        { System.out.println(s.getStockId()+"  "+s.getStockCode()+"  "+s.getStockName());
        }
       
   
       
    }
}