package com.example.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.example.controller.StudentController;
import com.example.model.MarksDto;
import com.example.model.StudentDepartmentDto;
import com.example.model.StudentDto;
import com.example.model.entity.Marks;
import com.example.model.entity.Student;
import com.example.model.entity.StudentDepartment;
import com.example.service.StudentService;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

	@InjectMocks
	private StudentController Student;

	@Mock
	private StudentService testStudentService;

	@Test
	public void testSaveStudentDtoRecord() {

		String Expected = "Student Record Succesfully Created";
		
		MarksDto marksDto1 = new MarksDto(1, "Maths", 100);
		MarksDto marksDto2 = new MarksDto(2, "English", 100);
		
		List<MarksDto> lstMarksDto1 = new ArrayList<>();
		lstMarksDto1.add(marksDto1);
		lstMarksDto1.add(marksDto2);

		MarksDto marksDto3 = new MarksDto(3, "Maths", 90);
		MarksDto marksDto4 = new MarksDto(4, "English", 99);

		List<MarksDto> lstMarksDto2 = new ArrayList<>();
		lstMarksDto2.add(marksDto3);
		lstMarksDto2.add(marksDto4);

		StudentDto StudentDto1 = new StudentDto(100, "Vijay", lstMarksDto1);
		StudentDto StudentDto2 = new StudentDto(101, "Ajay", lstMarksDto2);

		List<StudentDto> lstStudentDto = new ArrayList<>();
		lstStudentDto.add(StudentDto1);
		lstStudentDto.add(StudentDto2);
		
		StudentDepartmentDto studentDepartmentDto = new StudentDepartmentDto(100,1, "CSC", lstStudentDto);
		when(testStudentService.createStudentDetails(Mockito.any())).thenReturn(Expected);
		String Actual =testStudentService.createStudentDetails(studentDepartmentDto);
		assertEquals(Expected, Actual);

	}

	@Test
	public void fetchStudentByDepartmentIdTest() {

		MarksDto marksDto1 = new MarksDto(1, "Maths", 100);
		MarksDto marksDto2 = new MarksDto(2, "English", 100);
		
		List<MarksDto> lstMarksDto1 = new ArrayList<>();
		lstMarksDto1.add(marksDto1);
		lstMarksDto1.add(marksDto2);

		MarksDto marksDto3 = new MarksDto(3, "Maths", 90);
		MarksDto marksDto4 = new MarksDto(4, "English", 99);

		List<MarksDto> lstMarksDto2 = new ArrayList<>();
		lstMarksDto2.add(marksDto3);
		lstMarksDto2.add(marksDto4);

		StudentDto StudentDto1 = new StudentDto(100, "Vijay", lstMarksDto1);
		StudentDto StudentDto2 = new StudentDto(101, "Ajay", lstMarksDto2);

		List<StudentDto> lstStudentDto = new ArrayList<>();
		lstStudentDto.add(StudentDto1);
		lstStudentDto.add(StudentDto2);
		
		StudentDepartmentDto studentDepartmentDto = new StudentDepartmentDto(100,1, "CSC", lstStudentDto);
		List<StudentDepartmentDto> lstStudentDepartmentDto = new ArrayList<>();
		lstStudentDepartmentDto.add(studentDepartmentDto);
		
		when(testStudentService.fetchStudentByDepartmentId(Mockito.anyInt())).thenReturn(lstStudentDepartmentDto);
		List<StudentDepartmentDto>actual=testStudentService.fetchStudentByDepartmentId(1);
		System.out.println(actual);
		assertEquals(actual.get(0).getName(), lstStudentDepartmentDto.get(0).getName(), "Student Name is Matching");
	}

}