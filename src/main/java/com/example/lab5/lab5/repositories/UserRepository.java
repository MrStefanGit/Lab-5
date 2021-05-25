package com.example.lab5.lab5.repositories;

import com.example.lab5.lab5.domains.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findUserByUsername(String username);

}
