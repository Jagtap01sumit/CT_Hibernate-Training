package com.training.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.training.modal.Employee;
import com.training.util.HibernateUtil;

public class HQLDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Employee emp1 = new Employee(101, "Sumit jagtap", "IT", 25000);
//		
//		Session session = HibernateUtil.getSession();
//		Transaction tx = session.beginTransaction();
//		
//		session.save(emp1);
//		
//		tx.commit();
//		session.close();
//		HibernateUtil.closeSessionFactory();
		
		Session session = HibernateUtil.getSession();
//		Query<Employee> query=session.createQuery("FROM Employee");
//		Query<Employee> query=session.createQuery("FROM Employee WHERE department = 'HR'");
//		Query<Employee> query = session.createQuery("FROM Employee WHERE department = ?1 AND salary > ?2", Employee.class);
		
//		Query<Employee> query = session.createQuery("FROM Employee WHERE department =:dept AND salary > :sal", Employee.class);
//		query.setParameter("dept", "HR"); // set department parameter
//		query.setParameter("sal", 5000); // set salary parameter
		
		
//		Query<Employee> query = session.createQuery("FROM Employee ORDER BY salary DESC");
//		List<Employee> employees = query.list();
//		employees.forEach(System.out::println);
		
		//if we want particular fields data then we use Object[]
//		Query<Object[]> query = session.createQuery("SELECT name, department from Employee");
//		List<Object[]> employees = query.getResultList();
//		employees.forEach(row-> System.out.println(row[0]+" "+row[1]));
		
		// if we want only single field data then we can directly mention the datatype
//		Query<String> query = session.createQuery("SELECT name from Employee");
//		List<String> employees = query.getResultList();
//		employees.forEach(name-> System.out.println(name));
//		
//		session.close();
		
		//UPDATE 
//		Transaction tx = session.beginTransaction();
//		Query query = session.createQuery("UPDATE Employee SET salary = salary + ?1 WHERE department = ?2");
//		query.setParameter(1, 100000);
//		query.setParameter(2, "HR");
//		
//		int count = query.executeUpdate();
//		tx.commit();
//		System.out.println("COUNT: "+count);
		
		
		//DELETE
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("DELETE from Employee WHERE department = ?1");
		query.setParameter(1, "HR");
		int count = query.executeUpdate();
		tx.commit();
		
		session.close(); 
		HibernateUtil.closeSessionFactory();
	}

}
