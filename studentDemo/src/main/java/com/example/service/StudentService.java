package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.StudentRepository;
import com.example.model.StudentDepartmentDto;
import com.example.model.entity.StudentDepartment;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	ModelMapper modelMapper;

	public String createStudentDetails(StudentDepartmentDto dto) {
		StudentDepartment StudentDepartment = generateEntityFromDto(dto);
		StudentDepartment = studentRepository.save(StudentDepartment);
		if (StudentDepartment == null) {
			return "Student Record is not Created";
		} else {
			return "Student Record Succesfully Created";
		}
	}

	private StudentDepartment generateEntityFromDto(StudentDepartmentDto dto) {
		StudentDepartment StudentDepartment = modelMapper.map(dto, StudentDepartment.class);
		return StudentDepartment;
	}

	private StudentDepartmentDto generateDtoFromEntity(StudentDepartment department) {
		StudentDepartmentDto dto = modelMapper.map(department, StudentDepartmentDto.class);
		return dto;
	}
//
//	public List<StudentDepartmentDto> fetchStudentByDepartmentId(int id) {
//
//		List<StudentDepartmentDto> studentDepartmentDto = new ArrayList<>();
//		List<StudentDepartment> studentDepartment = studentRepository.findAllById(id);
//
//		for (StudentDepartment studData : studentDepartment) {
//			studentDepartmentDto.add(generateDtoFromEntity(studData));
//		}
//		return studentDepartmentDto;
//	}
	
	public List<StudentDepartment> fetchStudentByDepartmentId(int id) {

		return new ArrayList<StudentDepartment> ( studentRepository.findAllById(id));

		
	}

	public void deleteStudentById(int id) {
		
		
	}

}
