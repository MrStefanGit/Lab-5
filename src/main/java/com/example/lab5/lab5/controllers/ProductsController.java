package com.example.lab5.lab5.controllers;

import com.example.lab5.lab5.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductsController {
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showProducts(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "products";
    }
}
