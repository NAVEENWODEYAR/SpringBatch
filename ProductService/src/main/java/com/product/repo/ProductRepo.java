package com.product.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.product.modal.Product;

public interface ProductRepo extends MongoRepository<Product, String>
{
	// findByName queries,
	public Product findByname(String name);
	
//	public Boolean isProductExistsByName(String name);
}
