package com.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author NaveenWodeyar
 * @date 28-08-2024
 */
@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @GetMapping
    public ResponseEntity<?> test() {
        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Content-Type", "application/String")
                .body("Welcome to the Product_Service!,");
    }
}
