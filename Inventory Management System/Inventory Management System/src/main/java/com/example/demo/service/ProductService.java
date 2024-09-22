package com.example.demo.service;

import com.example.demo.Dto.TotalValueDto;
import com.example.demo.entity.ProductEntity;

public interface ProductService {

	public String addProduct(ProductEntity product);
	
	public String updateProduct(int id,int quantity);
	
	public TotalValueDto valueOfInventory();
}
