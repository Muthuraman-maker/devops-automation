package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOwner {

	private String ownerName;
	
	@Override
	public String toString() {
		return "User [name=" + ownerName + "]";
	}
}
