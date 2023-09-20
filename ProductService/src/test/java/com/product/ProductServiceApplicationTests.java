package com.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.product.repo.ProductRepo;

@SpringBootTest
class ProductServiceApplicationTests 
{

	// Dependency injection,
	@Autowired
	private ProductRepo productRepo;
	
	@Test
	void contextLoads() 
	{
		System.out.println("J unit test");
	}
	
	@Test
	void controllerTest()
	{
		
	}

}
