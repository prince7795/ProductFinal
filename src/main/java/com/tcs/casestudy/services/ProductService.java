package com.tcs.casestudy.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.tcs.casestudy.exceptions.ExpiryDateException;
import com.tcs.casestudy.models.Product;

public interface ProductService {
	public Product addProduct(Product product);
	public String updateProduct(long id, Product updateProduct);
	public String deleteProduct(long id);
	public Optional<Product> findById(long id);
	public Optional<List<Product>> getProducts();
	public Optional<List<Product>> findByCategory(long category);
}
