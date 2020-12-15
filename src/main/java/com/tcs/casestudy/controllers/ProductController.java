package com.tcs.casestudy.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
//
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.tcs.casestudy.exceptions.ExpiryDateException;
import com.tcs.casestudy.exceptions.ResourceNotFoundException;
import com.tcs.casestudy.models.Product;
import com.tcs.casestudy.services.ProductService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/product")
public class ProductController {
	@Autowired
	ProductService productService;
	
	//Implement get, post, put, delete mappings here.
	@GetMapping("/getAllProducts/")
	//@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Product> getProducts() {
		return productService.getProducts().get();
	}
	
	@GetMapping("/getProduct/{id}")
	//@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<Product> getProductById(@PathVariable("id") long productId) throws ResourceNotFoundException {
		Product product = productService.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product not found"));
		
		return ResponseEntity.ok().body(product);
	}
	
	@PostMapping("/{createProduct}")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> createProduct(@RequestBody Product product,UriComponentsBuilder uriComponentsBuilder,HttpServletRequest request) {
	
		Product product2 = productService.addProduct(product);
		UriComponents uriComponents = uriComponentsBuilder
				.path(request.getRequestURI()+"/{id}")
				.buildAndExpand(product2.getProductId());
		
		
	  return ResponseEntity.created(uriComponents.toUri()).body(product2);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public Map<String, Boolean> deleteProductById(@PathVariable int id) throws ResourceNotFoundException { 
		Product product = productService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found"));
		
		productService.deleteProduct(id);
		HashMap<String, Boolean> hashMap = new HashMap<>();
		hashMap.put("deleted", Boolean.TRUE);
		
		return hashMap;
	}
	
	@PutMapping("/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id,
												@Valid @RequestBody Product product) throws ResourceNotFoundException{
		Product product2 = productService.findById(id).orElseThrow(()->new ResourceNotFoundException("Product Not Found"));
		product.setProductId(id);
		Product product3 = productService.addProduct(product);
		return ResponseEntity.ok(product3);
		
	}
	
	@GetMapping("/category/{category}")
	//@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<List<Product>> findByCategory(@PathVariable("category") long category) throws ResourceNotFoundException {
		List<Product> product = productService.findByCategory(category).orElseThrow(()-> new ResourceNotFoundException("Category not found"));
		
		return ResponseEntity.ok(product);
	}
	
//	@GetMapping("/expirycheck/{expirydate}")
//	//@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
//	public ResponseEntity<Product> checkExpiryDate(@PathVariable("expirydate") long productId) throws ExpiryDateException {
//		Product product = productService.checkExpiryDate(productId);
//		
//		return ResponseEntity.ok(product);
//	}
	
	
	
}
