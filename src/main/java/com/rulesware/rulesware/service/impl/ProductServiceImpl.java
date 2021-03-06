package com.rulesware.rulesware.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rulesware.rulesware.entity.Product;
import com.rulesware.rulesware.repository.ProductRepository;
import com.rulesware.rulesware.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> retrieveAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public Product retrieveById(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).orElse(null);
	}
}
