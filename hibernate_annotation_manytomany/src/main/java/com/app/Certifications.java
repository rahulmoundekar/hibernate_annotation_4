package com.app;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "certification")
public class Certifications {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String certificate;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_certification", joinColumns = { @JoinColumn(name = "cid") }, inverseJoinColumns = {
			@JoinColumn(name = "emp_id") })
	private List<Employee> employeeList;

	@Override
	public String toString() {
		return "Certifications [id=" + id + ", certificate=" + certificate + "]";
	}
}
