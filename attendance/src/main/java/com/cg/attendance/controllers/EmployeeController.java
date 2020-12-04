package com.cg.attendance.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.attendance.entities.Employee;
import com.cg.attendance.services.EmployeeService;
import com.cg.attendance.services.MapValidationErrorService;


@RestController
@RequestMapping("/api/attendanceapplication")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	@Autowired
	private MapValidationErrorService mapValidateErrorService;

	@PostMapping("/add")
		public ResponseEntity<?> createNewProject(@Valid @RequestBody Employee employee, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidateErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		Employee newEmployee = empService.addEmployee(employee);
		
		return new ResponseEntity<Employee>(newEmployee, HttpStatus.CREATED);
	
	}

}