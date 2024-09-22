package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.TotalValueDto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	private ProductService productService;
	ProductController(ProductService productService)
	{
		this.productService=productService;
	}
@PostMapping("/products")
public ResponseEntity<String> addProduct(@Valid@RequestBody ProductEntity product)
{
	return new ResponseEntity<String>(productService.addProduct(product),HttpStatus.CREATED);
}
@PutMapping("/products/{id}")
public ResponseEntity<String> updateProduct(@PathVariable("id")int id,@RequestParam("quantity") int quantity)
{
	return new ResponseEntity<String>(productService.updateProduct(id,quantity),HttpStatus.OK);
}
@GetMapping("/inventory/value")
public ResponseEntity<TotalValueDto> getInventoryValue()
{
	return new ResponseEntity<TotalValueDto>(productService.valueOfInventory(),HttpStatus.OK);
}
	
	
}
