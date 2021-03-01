package com.app.entity;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.app.utility.HibernateUtiltity;

public class Test {

	public void save() {

		Employee employee = new Employee();
		employee.setName("abc");

		Session session = HibernateUtiltity.getSessionFactory().openSession();

		session.save(employee);
		session.beginTransaction().commit();
	}

	public void findAll() {

		Session session = HibernateUtiltity.getSessionFactory().openSession();

		CriteriaQuery<Employee> cq = session.getCriteriaBuilder().createQuery(Employee.class);
		cq.from(Employee.class);
		List<Employee> employeeList = session.createQuery(cq).getResultList();
		employeeList.forEach(System.out::println);
	}

	public Employee findOne() {

		Session session = HibernateUtiltity.getSessionFactory().openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = session.getCriteriaBuilder().createQuery(Employee.class);
		Root<Employee> root = cq.from(Employee.class);
		cq.select(root);
		cq.where(builder.equal(root.get("id"), 23));
		Employee employee = session.createQuery(cq).getSingleResult();
		System.out.println(employee);
		return employee;
	}

	public void deleteEmp() {
		Employee employee = findOne();
		Session session = HibernateUtiltity.getSessionFactory().openSession();
		session.delete(employee);
		session.beginTransaction().commit();
	}

	public static void main(String[] args) {

		Test test = new Test();
		// test.save();
		test.deleteEmp();
		test.findAll();
		test.findOne();
	}

}
