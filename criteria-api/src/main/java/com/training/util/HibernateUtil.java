package com.training.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.citiustech.model.Employee;






public class HibernateUtil{
    private static SessionFactory factory;     
    
    public static Session getSession(){
        return factory.openSession();
    }
    
    public static void closeSessionFactory(){
      factory.close();
    }
    
    static {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Employee.class)
        	;//reding the configuratio mapping properties in resource files.
                                                                    
        StandardServiceRegistryBuilder  builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()); // this properties are get from the resource file where          //we save the resouce in a form of key value pair key -> name , value-> value of the xml ele. 
        factory=configuration.buildSessionFactory(builder.build());
    }
}