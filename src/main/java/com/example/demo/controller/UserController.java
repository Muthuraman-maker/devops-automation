package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;

@RestController
@RequestMapping("/ourapp")
public class UserController {
	
	@RequestMapping(value = {"/seconduser", "/second-user", "/secondUser"}, 
			method = RequestMethod.GET)
	public String getSecondUser() {
		return "getSecondUser()";
	}

	@GetMapping("/users/{name}")
	public String printUserName(@PathVariable("name") String name) {
		return "My name is "+name;
	}

	@GetMapping("/users/{name}/{age}/{location}")
	public String printUserInfo(@PathVariable String name, 
			@PathVariable Long age,
			@PathVariable String location) {
		return "My name is "+name+". I am "+age+" years old. I am living in "+location;
	}

	@GetMapping("/customers")
	public String getCustomerName(@RequestParam(defaultValue = "anonymous") String name) {
		return "My name is "+name;
	}

	@GetMapping("/employees")
	public String getEmployeeName(@RequestParam(required = false) String name) {
		return "My name is "+name;
	}

	@GetMapping("/user")
	public String getName(@RequestParam(name = "userName") String name) {
		return "My name is "+name;
	}

	@GetMapping("/userstt")
	public void printData(@Valid @RequestBody User user) {
		System.out.println("Printing the user data:"+user);
	}

	@GetMapping("/users")
	public @ResponseBody User getUser() {
		User user = new User();
		user.setFirstName("Muthu");
		user.setLastName("Raman");
		user.setAge(28);
		return user;
	}


}
