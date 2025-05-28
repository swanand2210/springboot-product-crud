package com.example.helloworld.service;

import com.example.helloworld.model.Product;
import com.example.helloworld.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    // ✅ Fix for getById
    public Product getById(int id) {
        return productRepository.findById(id).orElse(null); // safe fallback
    }

    // ✅ Fix for deleteById
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }
}
