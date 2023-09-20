package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.product.dto.*;
import com.product.modal.Product;
import com.product.service.ProductService;
import org.slf4j.*;

@RestController
@RequestMapping("/product")
public class ProductController 
{
	// DI(constructor injection)
	@Autowired 
	private ProductService productService;
	
	// adding the logger,
	Logger log = LoggerFactory.getLogger(ProductController.class);
	
	// API's
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody ProductResponse productResponse )
	{
		productService.createProduct(productResponse);
//		log.info("Data saved successfully,");
//		log.info("msg", new RuntimeException());
		
	}
	
	@GetMapping // get all product details,
	@ResponseStatus(HttpStatus.FOUND)
	public List<Product> getProducts()
	{
		List<Product> products = productService.getProducts();
		log.info("Products found");
			return products;
	}
	
	@GetMapping("/testPoint/{name}")
	@ResponseStatus(HttpStatus.OK)
	public String testMsg(@PathVariable String name)
	{
		log.debug("Request {}",name);
		String response = "Hi "+name+" you are Generating the log files";
		log.debug("Response {}",name);
		return response;
	}
	
	@RequestMapping(method = RequestMethod.GET,path = "/isBoolean")
	public Boolean isProductExistsByName(String name)
	{
		return productService.isProductExistsByName(name);
	}
	
}
