package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	private Long id;

	private String name;

	private Long age;

	private String location;
	
	private String email;
	
	private String bankId;

}
