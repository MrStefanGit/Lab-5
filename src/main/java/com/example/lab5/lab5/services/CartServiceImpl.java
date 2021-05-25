package com.example.lab5.lab5.services;

import com.example.lab5.lab5.domains.Cart;
import com.example.lab5.lab5.repositories.CartRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart save(Cart c) {
        return cartRepository.save(c);
    }

    @Override
    public List<Cart> getCartByUserId(Long userId) {
        return cartRepository.findAllByUserIdOrderByCreatedDateDesc(userId);
    }
}
