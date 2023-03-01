package com.api.products.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.products.entities.Product;
import com.api.products.entities.Response;
import com.api.products.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private Response response;

    public Iterable<Product> list() {
        return repository.findAll();
    }

    public ResponseEntity<?> createOrUpdate(Product product, String action) {
        if(product.getName().equals("")) {
            response.setMessage("Product name must be informed!");
            return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
        } else if(product.getBrand().equals("")) {
            response.setMessage("Product brand must be informed!");
            return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
        } else {
            if(action.equals("create")) {
                return new ResponseEntity<Product>(repository.save(product), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<Product>(repository.save(product), HttpStatus.OK);
            }
        }
    }

    public ResponseEntity<Response> remove(Long id) {
        repository.deleteById(id);
        response.setMessage("Product removed with successfully!");
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }
    
}
