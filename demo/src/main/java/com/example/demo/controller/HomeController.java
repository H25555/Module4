package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class HomeController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

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
    public String createProduct(@ModelAttribute Product product, @ModelAttribute Category category){
        product.setCategory(category);
        productService.addProduct(product);
        return "redirect:/products/create";
    }
    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable int id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("product",product);
        return "update";
    }
    @PostMapping("/update/{id}")
    public String updateProduct(@ModelAttribute Product product){
        productService.updateProduct(product);
        return "redirect:/products";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
