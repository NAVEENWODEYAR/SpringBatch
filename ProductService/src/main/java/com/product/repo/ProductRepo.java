package com.product.repo;

import com.product.modal.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepo extends MongoRepository<Product, String> {
    // findByName queries,
    public Product findByname(String name);

//	public Boolean isProductExistsByName(String name);
}
