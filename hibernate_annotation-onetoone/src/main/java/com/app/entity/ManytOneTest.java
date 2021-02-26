package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToOne;

import org.hibernate.Session;

public class ManytOneTest {

	public void save() {
		Employee employee = new Employee();
		employee.setName("Mukesh");

		Address a1 = new Address();
		a1.setCity("nashik");
		a1.setPincode(34343);
		a1.setEmployee(employee);

		Address a2 = new Address();
		a2.setCity("nagpur");
		a2.setPincode(9870);
		a2.setEmployee(employee);

		List<Address> addresses = new ArrayList<Address>();
		addresses.add(a1);
		addresses.add(a2);

		employee.setAddresses(addresses);

		Session session = HibernateUtility.getSession().openSession();

		session.save(employee);
		session.beginTransaction().commit();

		System.out.println("success");
	}

	public void selectAll() {
		Session session = HibernateUtility.getSession().openSession();
		session.createCriteria(Employee.class).list().forEach(System.out::println);
	}

	public static void main(String[] args) {
		ManytOneTest test = new ManytOneTest();
		test.save();
		test.selectAll();
	}

}
