package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private int idCur;
    private static List<Product> products;
    static {
        products = new ArrayList<>();
    }
    public List<Product> getProducts(){
        return products;
    }
    public void addProduct(Product product){
        product.setId(++idCur);
        products.add(product);
    }
    public void updateProduct(Product product){
        for (Product p: products){
            if(p.getId() == product.getId()){
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setCategory(product.getCategory());
            }
        }
    }
    public void deleteProduct(int id){
        Product product = new Product();
        for (Product p: products){
            if (p.getId() == id){
                product = p;
            }
        }
        products.remove(product);
    }
    public Product findById(int id){
        for (Product p: products){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }
}
