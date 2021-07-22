package com.example.springboot.services;

import com.example.springboot.models.Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("productsRepository")
public interface ProductRepository extends CrudRepository<Products, Long> {
}
