package com.example.lab5.lab5.services;


import com.example.lab5.lab5.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import com.example.lab5.lab5.domains.Product;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product p) {
        return productRepository.save(p);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
