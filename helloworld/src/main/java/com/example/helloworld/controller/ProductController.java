package com.example.helloworld.controller;

import com.example.helloworld.model.Product;
import com.example.helloworld.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product-list")
    public String getProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product-list";
    }

    @GetMapping("/add-product")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @PostMapping("/add-product")
    public String submitForm(@ModelAttribute Product product, Model model) {
        productService.addProduct(product);
        model.addAttribute("product", product);
        return "confirmation";
    }
    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable int id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "edit-product"; // create a form like add-product
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteById(id);
        return "redirect:/product-list";
    }


}
