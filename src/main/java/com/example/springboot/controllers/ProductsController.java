package com.example.springboot.controllers;

import com.example.springboot.models.Products;
import com.example.springboot.models.Users;
import com.example.springboot.services.IProductService;
import com.example.springboot.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductsController {
    @Autowired
    IProductService productService;

    @GetMapping("/product/{id}")
    public Products getUser(@PathVariable("id") long id) {
        return productService.getProductById(id);
    }


    @GetMapping("/products")
    public @ResponseBody
    Iterable<Products> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/newProduct")
    public @ResponseBody
    Products createProduct(@RequestBody Products products) {
        return productService.createProduct(products);
    }

    @PutMapping("/updateProduct")
    public @ResponseBody
    Products updateProduct(@RequestBody Products products) {
        return productService.updateProduct(products);
    }

    @DeleteMapping("/deleteProduct")
    public @ResponseBody String deleteProduct(@PathVariable("id") long id) {
        return productService.deleteProduct(id);
    }

}
