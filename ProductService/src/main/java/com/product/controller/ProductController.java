package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.product.dto.ProductDTO;
import com.product.dto.ProductResponse;
import com.product.modal.Product;
import com.product.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController 
{
	// DI(constructor injection)
	@Autowired 
	private ProductService productService;
	
	// API's
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody ProductResponse productResponse )
	{
		productService.createProduct(productResponse);
		log.info("Data saved successfully,");
		log.info("msg", new RuntimeException());
		
	}
	
	@GetMapping // get all product details,
	@ResponseStatus(HttpStatus.FOUND)
	public List<Product> getProducts()
	{
		List<Product> products = productService.getProducts();
		log.info("Products found");
						return products;
	}
	
}
