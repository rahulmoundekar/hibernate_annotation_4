package com.app;

import java.security.cert.CertificateFactorySpi;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

public class Test {

	public void save() {

		Employee employee = new Employee();
		employee.setName("Rahul");

		Employee employee1 = new Employee();
		employee1.setName("Mukesh");

		Session session = HibernateUtility.getSession().openSession();

		Certifications c1 = (Certifications) session.get(Certifications.class, 134);
		Certifications c2 = (Certifications) session.get(Certifications.class, 136);
		Certifications c3 = (Certifications) session.get(Certifications.class, 135);

		List<Certifications> certifications = new ArrayList<Certifications>();
		certifications.add(c1);
		certifications.add(c2);

		List<Certifications> certifications1 = new ArrayList<Certifications>();
		certifications1.add(c1);
		certifications1.add(c3);

		employee.setCertificationList(certifications);
		employee1.setCertificationList(certifications1);

		session.save(employee);
		session.save(employee1);

		session.beginTransaction().commit();
		System.out.println("saved");

	}

	public void selectAll() {

		Session session = HibernateUtility.getSession().openSession();

		session.createCriteria(Employee.class).list().forEach(System.out::println);

	}

	public static void main(String[] args) {
		Test test = new Test();
		// test.save();
		test.selectAll();
	}

}
