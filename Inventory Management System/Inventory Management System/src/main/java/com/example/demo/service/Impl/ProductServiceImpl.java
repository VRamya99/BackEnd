package com.example.demo.service.Impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Dto.TotalValueDto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repo.ProductRepository;
import com.example.demo.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository=productRepository;
	}

	@Override
	public String addProduct(ProductEntity product) {
		productRepository.save(product);
		return "product successfully added";
	}

	@Override
	public String updateProduct(int id, int quantity) {
		ProductEntity productEntity=productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("product is not found with the id "+id));
		
			productEntity.setQuantity(quantity);
			productRepository.save(productEntity);
		
		return "product quantity updated";
	}

	@Override
	public TotalValueDto valueOfInventory() {
		BigDecimal value=BigDecimal.ZERO;
		List<ProductEntity> products=productRepository.findAll();
		for(ProductEntity p:products)
		{
			 BigDecimal productValue = BigDecimal.valueOf(p.getQuantity()).multiply(p.getPrice());
		       
		        value = value.add(productValue);
			
		}
		return new TotalValueDto(value);
		
	}

}
