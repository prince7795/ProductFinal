package com.tcs.casestudy.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.casestudy.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByCategory(long category);
	//Product checkExpiryDate(Date expiryDate);
}
