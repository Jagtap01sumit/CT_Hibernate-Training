package com.citiustech.test;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;

import com.citiustech.model.Employee;
import com.training.util.HibernateUtil;

public class CriteriaApiDemo {
	public static void main(String[] args) {

//		projectionDemon();
//		fetchSingleColumn();
//		aggregationDemo();
//		totalSalary();
//		minSalary();
//		maxSalary();
		avgSalary();
	}

	public static void queryapi()

	{
		Session session = HibernateUtil.getSession();

// Step 1 => Create CriteriaBuilder object by calling getCriteriaBuilder()
		// method of session. CriteriaBuilder object is used to create CriteriaQuery
		// object.
		CriteriaBuilder builder = session.getCriteriaBuilder();

//Create a query object by creating an instance of CriteriaQuery
		CriteriaQuery<Employee> query = builder.createQuery(Employee.class);

//3. Set the query root by calling from() method on CriteriaQuery object to define range of variables in FROM clause.

		Root<Employee> root = query.from(Employee.class);

//4. Specify what type of result̥ will be by calling select() method.
		// query.select(root);
		// query.select(root).where(builder.equal(root.get("department"),"HR"));
//		query.select(root).where(builder.greaterThan(root.get("salary"),200000));
//		query.select(root).where(builder.like(root.get("name"),"A%"));
//		query.select(root).where(builder.greaterThan(root.get("salary"),20000),builder.equal(root.get("department"),"HR"));

//5. Prepare quer for execution.
		Query<Employee> q = session.createQuery(query);

//6. Execute the query.
		List<Employee> employees = q.getResultList();
		employees.forEach(System.out::println);

		session.close();
	}

	public static void projectionDemon() {
		Session session = HibernateUtil.getSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
		Root<Employee> root = query.from(Employee.class);
		query.multiselect(root.get("name"), root.get("department")); // SELECT name, department FROM Employee;

		Query<Object[]> q = session.createQuery(query);
		List<Object[]> data = q.getResultList();
		data.forEach(row -> System.out.println(row[0] + " - " + row[1]));
	}

	public static void fetchSingleColumn() {
		Session session = HibernateUtil.getSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<String> query = builder.createQuery(String.class);
		Root<Employee> root = query.from(Employee.class);
//		query.select(root.get("name"));// select From Employee;

		query.select(root.get("name")).where(builder.equal(root.get("department"), "HR"));// SELECT name from employee
																							// where department = admin

		Query<String> q = session.createQuery(query);
		List<String> names = q.getResultList();
		names.forEach(System.out::println);
		session.close();

	}

	public static void aggregationDemo() {
		// count(),min(),max(),avg()

		Session session = HibernateUtil.getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<Long> query = builder.createQuery(Long.class);
		Root<Employee> root = query.from(Employee.class);
		query.select(builder.count(root)); // SELECT COUNT(*) from Employees;

		Query<Long> q = session.createQuery(query);
		long count = q.getSingleResult();

		System.out.println("Total no. of Employees => " + count);
	}

	public static void totalSalary() {
		Session session = HibernateUtil.getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
		Root<Employee> root = query.from(Employee.class);
		query.select(builder.sum(root.get("salary")));

		Query<Integer> q = session.createQuery(query);
		Integer totalSalary = q.getSingleResult();
		System.out.println("Total salary => " + totalSalary);
		session.close();

	}
	public static void minSalary() {
		Session session = HibernateUtil.getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
		Root<Employee> root = query.from(Employee.class);
		query.select(builder.min(root.get("salary")));

		Query<Integer> q = session.createQuery(query);
		Integer minSalary = q.getSingleResult();
		System.out.println("MIN salary => " + minSalary);
		session.close();

	}
	public static void maxSalary() {
		Session session = HibernateUtil.getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
		Root<Employee> root = query.from(Employee.class);
		query.select(builder.max(root.get("salary")));

		Query<Integer> q = session.createQuery(query);
		Integer maxSalary = q.getSingleResult();
		System.out.println("MAX salary => " + maxSalary);
		session.close();

	}
	public static void avgSalary() {
		Session session = HibernateUtil.getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Double> query = builder.createQuery(Double.class);
		Root<Employee> root = query.from(Employee.class);
		query.select(builder.avg(root.get("salary")));

		Query<Double> q = session.createQuery(query);
		Double avgSalary = q.getSingleResult();
		System.out.println("MAX salary => " +avgSalary);
		session.close();

	}
}