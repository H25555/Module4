package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    private static List<Category> categories;
    static {
        categories = new ArrayList<>();
        categories.add(new Category(1,"Shirt"));
        categories.add(new Category(2,"Short"));
    }
    public List<Category> getAll(){
        return categories;
    }

}
