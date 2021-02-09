package com.rulesware.rulesware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rulesware.rulesware.entity.Product;
import com.rulesware.rulesware.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public List<Product> retrieveProducts(){
		return productService.retrieveAll();
	}
	
	@GetMapping("/products/{category}")
	public List<Product> retrieveProducts(@PathVariable String category){
		return productService.retrieveByCategory(category);
	}
}
