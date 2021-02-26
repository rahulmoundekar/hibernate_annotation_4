package com.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	private String name;

	private String mobile;

	@OneToOne(mappedBy="person", cascade=CascadeType.ALL)
	private Pancard pancard;

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", mobile=" + mobile + ", pancard=" + pancard + "]";
	}

	
}

