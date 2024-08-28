package com.product.controller;

import com.product.dto.ProductResponse;
import com.product.modal.Product;
import com.product.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Product_Controller",description = "Product CRUD operations endPoints,")
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @GetMapping
    public ResponseEntity<?> greet() {
        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Content-Type", "application/String")
                .body("Welcome to the Product_Service!,");
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductResponse productResponse) {
        productService.createProduct(productResponse);
        log.info("Data saved successfully,");
        log.info("msg", new RuntimeException());

    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Product> getProducts() {
        List<Product> products = productService.getProducts();
        log.info("Products found");
        return products;
    }

    @GetMapping("/testPoint/{name}")
    @ResponseStatus(HttpStatus.OK)
    public String testMsg(@PathVariable String name) {
        log.debug("Request {}", name);
        String response = "Hi " + name + " you are Generating the log files";
        log.debug("Response {}", name);
        return response;
    }

}
