package com.product.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.product.modal.Product;

public interface ProductRepo extends MongoRepository<Product, String>
{
	public Product findByname(String name);
}
