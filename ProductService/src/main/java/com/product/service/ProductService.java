package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dto.ProductDTO;
import com.product.modal.Product;
import com.product.repo.ProductRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService 
{
	// DI(constructor injection)
	@Autowired
	private ProductRepo productRepo;
	
	// INSERT INTO TABLE product VALUES();
	public void createProduct(ProductDTO productDTO)
	{
		Product product = Product.builder()
							.name(productDTO.getName())
							.description(productDTO.getDescription())
							.price(productDTO.getPrice())
							.build();
				
				productRepo.save(product);
				log.info("Product {} is saved",product.getId());	
				
	}
	
	// SELECT * FROM product;
	public List<Product> getProducts()
	{
		List<Product> product = productRepo.findAll();
		return product;
	}
	
	// SELECT * FROM product WHERE product.name=name;
	public Product getProduct(String name)
	{
		return productRepo.findByname(name);
	}
	
}
