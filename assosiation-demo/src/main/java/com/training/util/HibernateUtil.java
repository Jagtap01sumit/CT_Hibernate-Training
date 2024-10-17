package com.training.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.training.modal.Cart;
import com.training.modal.Person;
import com.training.modal.Product;
import com.training.modal.Vehicle;



public class HibernateUtil{
    private static SessionFactory factory;     // from org.hibernate.SessionFactory
    
    public static Session getSession(){
        return factory.openSession();
    }
    
    public static void closeSessionFactory(){
      factory.close();
    }
    
    static {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Person.class).addAnnotatedClass(Vehicle.class).addAnnotatedClass(Cart.class).addAnnotatedClass(Product
        		.class)
        	;//reding the configuratio mapping properties in resource files.
                                                                    
        StandardServiceRegistryBuilder  builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()); // this properties are get from the resource file where          //we save the resouce in a form of key value pair key -> name , value-> value of the xml ele. 
        factory=configuration.buildSessionFactory(builder.build());
    }
}