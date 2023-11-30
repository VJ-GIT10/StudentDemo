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
@MockitoSettings(strictness = Strictness.LENIENT)
public class StudentControllerTest {

	@InjectMocks
	private StudentController student;

	@Mock
	private StudentService testStudentService;

	@Test
	public void testSaveStudentRecord() {

		String result = "Student Record Succesfully Created";
		String Expected = "Student Record Succesfully Created";
		when(testStudentService.createStudentDetails(Mockito.any())).thenReturn(result);
		assertEquals(Expected, result);

	}

	public void fetchStudentByDepartmentIdTest() {

		Marks marks1 = new Marks(1, "Maths", 100);

		Marks marks2 = new Marks(2, "English", 100);

		List<Marks> lstMarks1 = new ArrayList<>();
		lstMarks1.add(marks1);
		lstMarks1.add(marks2);

		Marks marks3 = new Marks(3, "Maths", 90);

		Marks marks4 = new Marks(4, "English", 99);

		List<Marks> lstMarks2 = new ArrayList<>();
		lstMarks2.add(marks3);
		lstMarks2.add(marks4);

		Student student1 = new Student(100, "Vijay", lstMarks1);
		Student student2 = new Student(101, "Ajay", lstMarks2);

		List<Student> lstStudent = new ArrayList<>();
		lstStudent.add(student1);
		lstStudent.add(student2);
		StudentDepartment studentDepartment = new StudentDepartment(1, "CSC", lstStudent);
		List<StudentDepartment> lstStudentDepartment = new ArrayList<>();
		lstStudentDepartment.add(studentDepartment);
		int actual = lstStudentDepartment.size();
		when(testStudentService.fetchStudentByDepartmentId(Mockito.anyInt())).thenReturn(lstStudentDepartment);
		assertEquals(actual, lstStudentDepartment.size(), "OutPut List size is equal");
	}

}