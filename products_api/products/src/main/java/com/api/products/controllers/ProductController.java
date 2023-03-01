package com.api.products.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.products.entities.Product;
import com.api.products.entities.Response;
import com.api.products.services.ProductService;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/health")
    public String health() {
        return "API Health OK";
    }

    @GetMapping("/products")
    public Iterable<Product> list() {
        return service.list();
    }

    @PostMapping("/products")
    public ResponseEntity<?> create(@RequestBody Product product) {
        return service.createOrUpdate(product, "create");
    }

    @PutMapping("/products")
    public ResponseEntity<?> update(@RequestBody Product product) {
        return service.createOrUpdate(product, "update");
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Response> remove(@PathVariable("id") Long id) {
        return service.remove(id);
    }

}
