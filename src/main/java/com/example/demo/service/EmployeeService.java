package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Product;
import com.example.demo.exeptions.EmployeeNotFoundException;
import com.example.demo.exeptions.NoDataFoundException;
import com.example.demo.exeptions.ResourceNotFoundException;

//we are loading some static data inside the static block. And, we have created a method to get the Employee based on the Id.

@Service	
public class EmployeeService {
	
private static List<Employee> list = new ArrayList<>();
	
	static {
		Employee e = new Employee(1, "Employee 1", 28, "India");
		list.add(e);
		
		e = new Employee(2, "Employee 2", 25, "India");
		list.add(e);
		
		e = new Employee(3, "Employee 3", 30, "India");
		list.add(e);
		
		e = new Employee(4, "Employee 4", 48, "India");
		list.add(e);
		
		e = new Employee(5, "Employee 5", 27, "India");
		list.add(e);
	}
	
	public List<Employee> getList () {
		if (list.size() > 0) {
			return list;
		}
		throw new NoDataFoundException("No employees available");
	}
	
	public Employee getEmployee (Integer id) {
		Optional<Employee> theEmployee = list.stream().filter(e -> e.getId() == id).findFirst();
		if (theEmployee.isPresent()) {
			return theEmployee.get();
		}
		throw new EmployeeNotFoundException("Employee not found for the id ->"+id);
	}

	
}
