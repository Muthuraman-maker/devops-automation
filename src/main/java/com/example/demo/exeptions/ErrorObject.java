package com.example.demo.exeptions;

import com.example.demo.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorObject {

	private int status;

	private String message;

	private long timestamp;
}
