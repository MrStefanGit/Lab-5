package com.example.lab5.lab5.repositories;

import com.example.lab5.lab5.domains.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

    List<Cart> findAllByUserIdOrderByCreatedDateDesc(Long userId);

}
