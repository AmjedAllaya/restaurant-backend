package com.example.dishes.product.service;


import com.example.dishes.product.model.Product;
import com.example.dishes.product.repository.ProductRepo;

import java.util.List;

public class ProductServiceImpl implements ProductService {
	private final ProductRepo productRepo;
	public ProductServiceImpl(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}
	@Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }
	
	@Override
	public Product getProduct(long Id) {
		return productRepo.getById(Id);
	}
	@Override
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}
	@Override
	public Product updateProduct(Product product) {
		return productRepo.save(product);
	}
	@Override
	public void deleteProduct(long Id) {
		productRepo.deleteById(Id);
		
	}


}
