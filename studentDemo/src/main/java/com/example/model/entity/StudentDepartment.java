package com.example.model.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class StudentDepartment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	private int id;
	private String name;
	@OneToMany(targetEntity=Student.class , mappedBy="id",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Student> student;
}
