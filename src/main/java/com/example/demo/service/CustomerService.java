package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;

@Service
public class CustomerService {
	private static List list = new ArrayList<>();
	static {
		Customer c = new Customer();
		c.setId(1L);
		c.setName("muthu");
		c.setAge(28L);
		c.setEmail("muthu@gmail.com");
		c.setBankId("zkxi190");
		c.setLocation("India");
		list.add(c);
		
		c = new Customer();
		c.setId(2L);
		c.setName("viswa");
		c.setEmail("v@gmail.com");
		c.setBankId("nbkv1234");
		c.setAge(30L);
		c.setLocation("India");
		list.add(c);
		
		c = new Customer();
		c.setId(3L);
		c.setName("sarva");
		c.setEmail("sarva@gmail.com");
		c.setBankId("nbkiuyb1");
		c.setAge(31L);
		c.setLocation("India");
		list.add(c);
	}
	
	public List getCustomerList() {
		return list;
	}

	public ArrayList<Customer> getCustomerDetails(String customers) {
		// TODO Auto-generated method stub
		List<Customer> customersListFromApi = new ArrayList<>();
		ArrayList<Customer> cusObj = new ArrayList<>();
		String arr[];
		if(customers.contains(" ")) {
			 String arr1[] = customers.split(" ");
			 arr = arr1;
		}else {
			 String arr1[] = customers.split(",");
			 arr = arr1;
		}
		List<String> obj1 = Arrays.asList(arr);
		Set<String> streamArr = new HashSet<>(obj1);
		customersListFromApi = getCustomerList();
		for(Customer customer: customersListFromApi) {
				String bankId = customer.getBankId();
				for(String dumBank: streamArr) {
					if(bankId.equalsIgnoreCase(dumBank)) {
						cusObj.add(customer);
					}
				}
		}
		
		return cusObj;
	}
}
