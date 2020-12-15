package com.tcs.casestudy.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.casestudy.exceptions.ExpiryDateException;
import com.tcs.casestudy.models.Product;
import com.tcs.casestudy.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
// applying singleton 
	// task for u
	
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		Product product2 = null;
		try {
			product2 = productRepository.save(product);
			return product2;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Optional<Product> findById(long id) {
		// TODO Auto-generated method stub
		Optional<Product> byId = productRepository.findById(id);
		Product product = byId.orElse(null);
		Date currentDate = new Date();
		if(product!=null && product.getExpiryDate().before(currentDate)) {
			throw new ExpiryDateException("Product date expired");
		}
		return Optional.ofNullable(product);
	}

	@Override
	public String deleteProduct(long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
		//assertThat(productRepository.count()).isEqual(1);
		return "Deleted Successfully";
	}

	@Override
	public Optional<List<Product>> getProducts() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(productRepository.findAll());
	}

	@Override
	public Optional<List<Product>> findByCategory(long category) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(productRepository.findByCategory(category));
		//return null;
	}

	@Override
	public String updateProduct(long id, Product updateProduct) {
		// TODO Auto-generated method stub
		productRepository.findById(id);
		return "Updated";
	}
	
//	public Product checkExpiryDate(long id){ 
//		Date expiryDate = productRepository.checkExpiryDate(expiryDate);
//		Date today = Calendar.getInstance().getTime();
//		System.out.println(today);
//		
//		Optional<Product> product = null;
//		try {
//			product = productRepository.findById(id);
//			if(product != null) {
//				if(today.compareTo(expiryDate)>0) {
//					System.out.println("Product Expired");
//				}
//				else {
//					System.out.println("Product Available");
//				}
//			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//		return null;
//		
//	}

}
