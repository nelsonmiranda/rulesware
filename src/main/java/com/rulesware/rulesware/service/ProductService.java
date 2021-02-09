package com.rulesware.rulesware.service;

import java.util.List;

import com.rulesware.rulesware.entity.Product;

public interface ProductService {

	List<Product> retrieveAll();

	Product retrieveById(Long id);
	
	Product addProduct(Product product);
}
