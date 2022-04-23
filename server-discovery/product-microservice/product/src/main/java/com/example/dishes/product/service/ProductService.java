package com.example.dishes.product.service;

import com.example.dishes.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductService {
	List<Product> getProducts();
	Product getProduct(long Id);
	Product addProduct(Product product);
	Product updateProduct(Product product);
	void deleteProduct (long Id);

}
