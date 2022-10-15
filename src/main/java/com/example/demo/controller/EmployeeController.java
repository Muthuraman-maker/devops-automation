package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.exeptions.EmployeeNotFoundException;
import com.example.demo.exeptions.ErrorObject;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService eService;

	@GetMapping("/employees/{id}")
	public Employee getEmployee (@PathVariable Integer id) {
		return eService.getEmployee(id);
	}

	@GetMapping("/employeesemp")
	public List<Employee> getList () {
		return eService.getList();
	}


	
	/*
	 * @GetMapping("/employees/{id}") public Employee get (@PathVariable Integer id)
	 * { return eService.getEmployee(id); }
	 */

	/*So inside the controller, we are creating a handler method to handle the custom exception. 
	 * We will add @ExceptionHandler annotation to the handler method and inside the method, 
	we will frame error response using ErrorObject and add it to the ResponseEntity.
	 */
	@ExceptionHandler
	public ResponseEntity<ErrorObject> handleException(EmployeeNotFoundException ex) {
		ErrorObject eObject = new ErrorObject();
		eObject.setStatus(HttpStatus.NOT_FOUND.value());
		eObject.setMessage(ex.getMessage());
		eObject.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ErrorObject>(eObject, HttpStatus.NOT_FOUND);
	}
}
