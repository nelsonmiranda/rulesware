package com.rulesware.rulesware.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping("/products/{productId}")
	public Product retrieveProducts(@PathVariable Long productId){
		return productService.retrieveById(productId);
	}
	
	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product newProduct){
		
		if(newProduct.getName() == null || newProduct.getPrice() <= 0)
			return ResponseEntity.badRequest().build();
		
		Product product = productService.addProduct(newProduct);
		
		if(product == null) 
			return ResponseEntity.noContent().build();
		
		//Sucess - URI of the new resource in the Response Header
		/*
		 * URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
		 * "/{productId}").buildAndExpand(product.getId()).toUri();
		 */
		
		//Status - Created
		return new ResponseEntity<Product>(product, HttpStatus.CREATED);
 	}
}
