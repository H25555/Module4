package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("/products")
public class HomeController {

    public final ProductService productService;

    public final CategoryService categoryService;

    public HomeController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String getIndex(Model model){
        model.addAttribute("products",productService.getProducts());
        model.addAttribute("categories",categoryService.getAll());
        return "index";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        Product product = new Product();
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("product",product);
        return "create";
    }
    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product){
        productService.addProduct(product);
        return "create";
    }
}
