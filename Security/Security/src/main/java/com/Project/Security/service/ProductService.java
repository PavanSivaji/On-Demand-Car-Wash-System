package com.Project.Security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.Project.Security.Repository.UserInfoRepository;
import com.Project.Security.dto.Product;
import com.Project.Security.entity.UserInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private List<Product> productList = new ArrayList<>(); // Ensure non-null list

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Fetch all products
    public List<Product> getProducts() {
        return productList;
    }

    // Fetch single product by ID
    public Product getProduct(int id) {
        return productList.stream()
                .filter(product -> product.getProductId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product with ID " + id + " not found!"));
    }

    // Add a new user with encrypted password
    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "User added successfully!";
    }

    // Fetch user by username for authentication
    public UserInfo getUserByUsername(String username) {
        Optional<UserInfo> user = repository.findByName(username);
        return user.orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " not found!"));
    }
}