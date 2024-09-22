package com.training.test;


import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.model.Employee;
import com.training.util.HibernateUtil;

public class TestEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee sumit = new Employee(101, "Sumit Jagtap", "IT", 50000);
		Employee alex = new Employee(102, "Alex Xander", "HR", 40000);
		Employee james = new Employee(103, "James F", "Manager", 150000);
		
	
//		int id =(int)session.save(sumit);// save the info in the db and return id;
//		session.persist(alex);     //persistent dosenot return the id
//		session.persist(james);
		
//		saveEmployee(sumit);
//		saveEmployee(alex);
//		saveEmployee(james);

		

//		deleteEmployee(102);
		
		
		
		//UPDATE -> without using .update()
//		Session session = HibernateUtil.getSession();
//		Transaction tx = session.beginTransaction();
//		//when u get obj from session then it attached to session
//		Employee employe = session.get(Employee.class, 103);
//		System.out.println("Employee -> "+ employe);
//		employe.setName("amit");
//		employe.setSalary(129081);
//		//this will get emp from db as an obj and update the values of obj, this obj is session obj so the values in db also change without using .update(object) ->  without using .update()
//		tx.commit();
//		session.close();
		
		
		//UPDATE -> using .update()
		//in this we just create obj with same field data which is not update , with the data which need to update and then pass argument in .update it fire the update query
		Session session = HibernateUtil.getSession();
//		Transaction tx = session.beginTransaction();
//		//if we have 50 of poperty which not want to change only one want to change, thus we mostly use .get() wali method metion above this method
//		Employee employe = new Employee(103, "amit", "Manager",10000);
//		session.update(employe);
//		tx.commit();
//		session.close();
//		
//		session.saveOrUpdate(employe); if the obj is not in db then it create the obj, and if exists then update.
		
		
		
		
		HibernateUtil.closeSessionFactory();
		
	}
	public static void saveEmployee(Employee emp) {

		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		session.persist(emp);
		
//		int id = (int)session.save(emp);
//		System.out.println("ID -> "+ id);
		
//		Employee employee=getEmployee(101);
//		System.out.println(employee);
		
//		Employee employe = session.load(Employee.class, 101); //when we ues .get() it not hit the db, it just create a dummy Employee class with id 101. 
//		System.out.println("not hit the db");
//		System.out.println(employe); 	//but when we try to print the db it hit the db only
		//when .get() method not find the emp in db then it return null
		//but .load() method trows an exception of ObjectNotFoundException
		
		tx.commit();
		session.close();
	}
	
	public static Employee getEmployee(int id) { //get the emp based on id
		Session session = HibernateUtil.getSession();

		Employee emp= session.get(Employee.class,id);
		session.close();
		return emp;
	}
	
	public static void deleteEmployee(int id) {
		//this method first fetch and then delete. because it fire first select query.
		Session session =HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Employee employe = new Employee();
		employe.setId(id);
		session.delete(employe); //it take argument as obj, we just create new emp, setid and pass
		
		//or
		
//		Employee emp= session.get(Employee.class,id);
//		session.delete(emp);

		
		tx.commit();

		
	}

}
