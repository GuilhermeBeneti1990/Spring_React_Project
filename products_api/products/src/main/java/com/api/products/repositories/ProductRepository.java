package com.api.products.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.products.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    
}
