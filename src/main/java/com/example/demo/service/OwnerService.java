package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ProductOwner;

@Service
public class OwnerService {

private static List list = new ArrayList<>(); 
	
	static {
		ProductOwner u = new ProductOwner("User 1");
		list.add(u);
		
		u = new ProductOwner("User 2");
		list.add(u);
		
		u = new ProductOwner("User 3");
		list.add(u);
	}
	
	public List getList () {
		return list;
	}
}
