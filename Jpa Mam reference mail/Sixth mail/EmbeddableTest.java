package com.cts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class EmbeddableTest {
	
	public static void main(String[] args) {
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	    Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
	      
	    SessionFactory factory=meta.getSessionFactoryBuilder().build();  
	    Session session=factory.openSession();  
	 
    Transaction t=session.beginTransaction();  

		Animal animal = new Animal("Lion A", "Africa");
	
		animal = new Animal("Elephnat A", "Asia");
		Elephant elephant = new Elephant(1, animal);
	
		session.save(elephant);
		session.getTransaction().commit();
		session.close();
	}

}
