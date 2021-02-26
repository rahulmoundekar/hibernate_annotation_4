package com.app.entity;

import java.util.List;

import org.hibernate.Session;

public class Test {

	public void save() {
		Person person = new Person();
		person.setName("Rahul");
		person.setMobile("34343434");

		Pancard pancard = new Pancard();
		pancard.setPanNo("AFDS34DFDF");

		pancard.setPerson(person);
		// person.setPancard(pancard);

		Session session = HibernateUtility.getSession().openSession();
		session.save(pancard);

		session.beginTransaction().commit();
		System.out.println("success");

	}

	@SuppressWarnings("unchecked")
	public void selectAll() {
		HibernateUtility.getSession().openSession().createCriteria(Person.class).list().forEach(System.out::println);
	}

	public void update() {

		Session session = HibernateUtility.getSession().openSession();

		Person person = (Person) session.get(Person.class, 5);
		person.setMobile("9158565604");

		Pancard pancard = person.getPancard();
		pancard.setPanNo("ASDFG3456K");
		pancard.setPerson(person);
		person.setPancard(pancard);

		session.update(person);

		session.beginTransaction().commit();

	}

	public void delete() {

		Session session = HibernateUtility.getSession().openSession();

		Person person = (Person) session.get(Person.class, 5);

		session.delete(person);

		session.beginTransaction().commit();
		System.out.println("deleted");

	}

	public static void main(String[] args) {

		Test test = new Test();
		test.save();
		test.selectAll();
		//test.delete();
	}

}
