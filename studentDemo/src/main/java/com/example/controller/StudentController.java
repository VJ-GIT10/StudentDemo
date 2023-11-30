package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.StudentDepartmentDto;
import com.example.model.entity.StudentDepartment;
import com.example.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentservice;

	@PostMapping("/saveStudentData")
	public String saveStudentRecord(@RequestBody StudentDepartmentDto dto) {

		String result = studentservice.createStudentDetails(dto);

		return result;
	}

	@GetMapping("/findStudentsByDepatrment/{id}")
	public List<StudentDepartment> findAllStudentDataByDept(@PathVariable int id) {
		return studentservice.fetchStudentByDepartmentId(id);
	}


	/**
	 * Builds the success response.
	 *
	 * @param status the status
	 * @param data   the data
	 * @return the response entity
	 */
	protected ResponseEntity<Object> buildSuccessResponse(HttpStatus status, Object data, String message) {
		Map<String, Object> response = new HashMap<>();
		response.put("status", status.value());
		response.put("data", data);
		response.put("message", message);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		return new ResponseEntity<>(response, headers, status);
	}

	/**
	 * Builds the error response.
	 *
	 * @param status  the status
	 * @param message the message
	 * @return the response entity
	 */
	protected ResponseEntity<Object> buildErrorResponse(HttpStatus status, Object data, String message) {
		Map<String, Object> response = new HashMap<>();
		response.put("status", status.value());
		response.put("data", data);
		response.put("error", status.getReasonPhrase());
		response.put("message", message);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		return new ResponseEntity<>(response, headers, status);
	}
}
