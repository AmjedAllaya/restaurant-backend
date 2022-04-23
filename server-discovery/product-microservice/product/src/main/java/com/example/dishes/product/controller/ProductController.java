package com.example.dishes.product.controller;


import com.example.dishes.product.model.Product;
import com.example.dishes.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@org.springframework.stereotype.Controller

public class ProductController {
    @org.springframework.beans.factory.annotation.Autowired
    com.nilesh.springCRUD.services.CategoryServices cservice;
	
	private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public Product saveProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    @GetMapping("/all")
    public List<Product> getAllproduct(){
        return productService.getProducts();

    }
    @PutMapping("/update")
    public Product update(@RequestBody Product product){
        return productService.updateProduct(product);
    }


    @GetMapping("/findById/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProduct(id);
    }
    
    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

}
