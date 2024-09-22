package com.example.order.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.dto.TotalPriceDto;
import com.example.order.entity.OrderEntity;
import com.example.order.entity.OrderItemsEntity;
import com.example.order.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class OrderController {
	
	private OrderService orderService;
	
	OrderController(OrderService orderService)
	{
		this.orderService=orderService;
	}
	@PostMapping("/orders")
	public ResponseEntity<String> createOrder(@Valid@RequestBody OrderEntity order)
	{
		return new ResponseEntity<String>(orderService.createOrder(order),HttpStatus.CREATED);
	}
	@PostMapping("/orders/{id}/items")
	public ResponseEntity<String> createOrder(@PathVariable("id") int id,@Valid@RequestBody List<OrderItemsEntity> items)
	{
		return new ResponseEntity<String>(orderService.addItemsToOrder(id,items),HttpStatus.OK);
	}
	@GetMapping("/orders/{id}/total")
	public ResponseEntity<TotalPriceDto> getTotalValue(@PathVariable("id") int id)
	{
		BigDecimal totalPrice = orderService.getTotalPrice(id);
		return new ResponseEntity<TotalPriceDto>(new TotalPriceDto(id, totalPrice),HttpStatus.OK);
	}

}
