package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long>{

	@Query("FROM Laptop WHERE brand = :brand")
	List<Laptop> getLaptopsByBrand (String brand);
	
	@Transactional
	@Modifying
	@Query("UPDATE Laptop SET price = :price WHERE name = :name")
	Integer updatePriceByName(BigDecimal price, String name);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Laptop WHERE name = :name")
	Integer deleteByName(String name);
	
}
