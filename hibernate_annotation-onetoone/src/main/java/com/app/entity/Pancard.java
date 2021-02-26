package com.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pancard")
public class Pancard {

	@Id
	@GeneratedValue(generator = "abc")
	@GenericGenerator(name = "abc", strategy = "foreign", parameters = @Parameter(name = "property", value = "person"))
	@Column(name = "id")
	private int id;

	@Column(name = "pancardno")
	private String panNo;

	@OneToOne
	@PrimaryKeyJoinColumn
	Person person;

	@Override
	public String toString() {
		return "Pancard [id=" + id + ", panNo=" + panNo + "]";
	}
}
