package com.product.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author NaveenWodeyar
 * @date 28-08-2024
 */
@Tag(name = "Test_Controller",description = "Test controller to check the application status,")
@RestController
@RequestMapping("/api/v1/test")
public class UserController {

    @GetMapping
    public ResponseEntity<?> test() {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "text/plain")
                .body("Welcome to the Product_Service!,");
    }
}
