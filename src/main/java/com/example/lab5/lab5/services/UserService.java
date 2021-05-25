package com.example.lab5.lab5.services;


import com.example.lab5.lab5.domains.User;

public interface UserService {
    User save(User f);
    boolean userExists(User f);
    public String getHash(String password);
    public boolean checkLogin(String username, String password);
}
