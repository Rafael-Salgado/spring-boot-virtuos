package com.example.springboot.services;

import com.example.springboot.models.Products;
import com.example.springboot.models.Users;

public interface IProductService {
    Products getProductById(long id);
    Iterable<Products> getAllProducts();
    Products createProduct(Products products);
    Products updateProduct(Products products);
    String deleteProduct(long id);
}
