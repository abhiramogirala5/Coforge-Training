package com.coforge.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.coforge.model.Employee;


public class HQLMain {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		//HQL SELECT
		/*
		Query query = session.createQuery("from Employee");
		List<Employee> list = query.list();
		System.out.println(list);
		*/
		
		//HQL Static Select
		/*
		Query query = session.createQuery("from Employee where eid = 101");
		List<Employee> list = query.list();
		System.out.println(list);
		*/
		
		/*
		//HQL Dynamic Select
		Query query = session.createQuery("from Employee where eid = :num");
		query.setParameter("num", 104);
		List<Employee> list = query.list();
		System.out.println(list);
		*/
		
		/*
		//Specific Column Select
		Query query = session.createQuery("select ename from Employee");
		List<String> list = query.list();
		System.out.println(list);
		*/
		
		//HQL Update
		/*
		Query query = session.createQuery("update Employee set ename = :name where eid = :id");
		query.setParameter("name", "Abhiram");
		query.setParameter("id", 101);
		int n = query.executeUpdate();
		if (n == 1) {
			System.out.println("Employee Details Updated");
		} else {
			System.out.println("Employee Details Not Updated");
		}
		*/
		
		//HQL Delete
		Query query = session.createQuery("delete from Employee where eid = :id");
		query.setParameter("id", 104);
		int n = query.executeUpdate();
		if (n ==1 ) {
			System.out.println("Employee Deleted");
		} else {
			System.out.println("Employee Not Deleted");
		}
		
		transaction.commit();
		session.close();
		factory.close();
		
		
	}

}
