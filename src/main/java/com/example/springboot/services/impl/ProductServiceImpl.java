package com.example.springboot.services.impl;

import com.example.springboot.models.Products;
import com.example.springboot.services.IProductService;
import com.example.springboot.services.ProductRepository;
import com.example.springboot.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Qualifier("Products")
public class ProductServiceImpl implements IProductService {


    @Autowired
    ProductRepository productRepository;


    @Override
    public Products getProductById(long id) {
            Optional<Products> product = productRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    public Iterable<Products> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Products createProduct(Products products) {
        return productRepository.save(products);
    }

    @Override
    public Products updateProduct(Products products) {
        return productRepository.save(products);
    }

    @Override
    public String deleteProduct(long id) {
        productRepository.deleteById(id);
        return "deleted";
    }
}
