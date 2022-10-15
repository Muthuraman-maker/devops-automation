package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService cService;
	
	@GetMapping("/custmers")
	public List getList() {
		return cService.getCustomerList();
	}
	
	@GetMapping("/custmers/{getCustomers}")
	public List<Customer> getCustomersDetails(@PathVariable("getCustomers") String customers) {
		ArrayList<Customer> cusObj = new ArrayList<>();
		cusObj = cService.getCustomerDetails(customers);
		return cusObj;
	}
	
	@GetMapping("/test/{id}")
	public String test (@PathVariable Long id) {
		return "The passed id is "+id;
	}
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The request is not valid")
	@ExceptionHandler(IllegalArgumentException.class)
	public String handleException (IllegalArgumentException ex) {
		return ex.getMessage();
	}
	
	@GetMapping("/test1")
	public String testRequestHeader (@RequestHeader String autho) {
		System.out.println("printing the auth "+autho);
		return "Success";
	}
	
	@GetMapping("/test2")
	public String handleRequestHeader (@RequestHeader Map<String, String> mapValues) {
		System.out.println("printing the header"+mapValues);
		return "Success";
	}
}
