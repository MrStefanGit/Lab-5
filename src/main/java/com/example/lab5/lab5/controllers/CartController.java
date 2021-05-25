package com.example.lab5.lab5.controllers;

import com.example.lab5.lab5.domains.Cart;
import com.example.lab5.lab5.domains.Product;
import com.example.lab5.lab5.services.CartService;
import com.example.lab5.lab5.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping
    public String showCart(Model model, @RequestParam(value = "quantity") String[] quantity) {
        for (String q : quantity) {
            System.out.println(q);
        }
        List<Product> products = productService.getProducts();
        HashMap<Product, Integer> cartProducts = new HashMap<>();
        Double totalPrice = 0.0;
        for (int i=0; i<products.size(); i++) {
            if (parseInt(quantity[i]) > 0) {
                cartProducts.put(products.get(i), parseInt(quantity[i]));
                totalPrice += products.get(i).getPrice() * parseDouble(quantity[i]);
                Cart c = new Cart(1L, products.get(i), parseInt(quantity[i]));
                cartService.save(c);
            }
        }


        model.addAttribute("cartProducts", cartProducts);
        model.addAttribute("totalPrice", totalPrice);
        return "cart";
    }
}