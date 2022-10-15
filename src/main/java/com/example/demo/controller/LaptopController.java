package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Laptop;
import com.example.demo.repository.LaptopRepository;

@RestController
public class LaptopController {

	@Autowired
	private LaptopRepository lRepo;
	
	@PostMapping("/laptopEntity")
	public String saveLaptop(@RequestBody Laptop laptop) {
		lRepo.save(laptop);
		return "success";
	}
	
	@GetMapping("/laptops")
	public List<Laptop> getAllLaptopsByBrand(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size){
		if((page!= null && page.equals("")) || (size != null && size.equals(""))){
			Pageable pages = PageRequest.of(page, size);
			return lRepo.findAll(pages).toList();
		}else {
		return lRepo.findAll();
		}
	}
	
	@GetMapping("/laptops/{brand}")
	public List<Laptop> getListOfLaptopsByBrand (@PathVariable String brand) {
		return lRepo.getLaptopsByBrand(brand);
	}
	
	@PutMapping("/laptops/update/{price}/{name}")
	public ResponseEntity<String> updatePriceByName(@PathVariable BigDecimal price, @PathVariable String name) {
		return new ResponseEntity<String>(lRepo.updatePriceByName(price, name)+" record(s) updated.", HttpStatus.OK);
	}
	
	@DeleteMapping("/laptops/delete/{name}")
	public ResponseEntity<String> deleteByName(@PathVariable String name) {
		return new ResponseEntity<String>(lRepo.deleteByName(name)+" record(s) deleted", HttpStatus.OK);
	}
	
	
}
