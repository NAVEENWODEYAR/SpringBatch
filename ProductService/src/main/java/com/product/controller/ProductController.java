package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.product.dto.ProductDTO;
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
	public void createProduct(@RequestBody ProductDTO productDTO )
	{
		productService.createProduct(productDTO);
		log.info("Data saved,");
		
	}

}
