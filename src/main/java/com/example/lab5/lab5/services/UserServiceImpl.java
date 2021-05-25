package com.example.lab5.lab5.services;

import com.example.lab5.lab5.domains.User;
import com.example.lab5.lab5.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private String loggedInUser = null;

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User f) {
        return userRepository.save(f);
    }

    @Override
    public boolean userExists(User f) {
        List<User> users = userRepository.findUserByUsername(f.getUsername());
        if (users.isEmpty()) {return false;}
        return true;
    }

    @Override
    public String getHash(String password) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        digest.reset();
        try {
            digest.update(password.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        return new BigInteger(1, digest.digest()).toString(16);
    }

    @Override
    public boolean checkLogin(String username, String password) {
        List<User> users = userRepository.findUserByUsername(username);
        if (users.isEmpty()) {
            return false;
        } else if (getHash(password).equals(users.get(0).getPassword())) {
            loggedInUser = username;
            return true;
        }
        return false;
    }


}
