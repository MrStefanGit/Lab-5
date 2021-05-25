package com.example.lab5.lab5.services;

import com.example.lab5.lab5.domains.Cart;

import java.util.List;

public interface CartService {
    Cart save(Cart c);
    List<Cart> getCartByUserId(Long userId);
}
