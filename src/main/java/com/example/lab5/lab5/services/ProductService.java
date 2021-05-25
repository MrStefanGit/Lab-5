package com.example.lab5.lab5.services;

import com.example.lab5.lab5.domains.Product;

import java.util.List;

public interface ProductService {
    Product save(Product p);
    List<Product> getProducts();
}
