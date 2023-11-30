package com.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.example.model.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class StudentDepartmentDto {

	private int id;
	private String departmentName;
	@OneToMany(targetEntity=Student.class, mappedBy="id", fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<StudentDto> student;
}