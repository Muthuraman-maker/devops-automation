package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.exeptions.NoDataFoundException;
import com.example.demo.exeptions.ResourceNotFoundException;

@Service
public class ProductService {
private static List<Product> list = new ArrayList<>();
	
	static {
		list.add(new Product(1, "iPhone XR", 500.00));
		list.add(new Product(2, "Galaxy Note 10", 700.00));
		list.add(new Product(3, "Oneplus Nord", 400.00));
		list.add(new Product(4, "Galaxy S10", 750.00));
		list.add(new Product(5, "iPhone 11", 700.00));
	}
	
	public List<Product> getList () {
		if (list.size() > 0) {
			return list;
		}
		throw new NoDataFoundException("No products available");
	}
	
	public Product getProduct(Integer id) {
		Optional<Product> theProduct = list.stream().filter(p -> p.getId() == id).findFirst();
		if (!theProduct.isPresent()) {
			throw new ResourceNotFoundException("Product not found for the id->"+id);
		}
		return theProduct.get();
	}
}
