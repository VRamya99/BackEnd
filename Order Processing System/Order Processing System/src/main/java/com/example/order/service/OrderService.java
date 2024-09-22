package com.example.order.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.order.dto.TotalPriceDto;
import com.example.order.entity.OrderEntity;
import com.example.order.entity.OrderItemsEntity;

public interface OrderService {

	public String createOrder(OrderEntity order);
	public String addItemsToOrder(int id,List<OrderItemsEntity> orderItems );
	public BigDecimal getTotalPrice(int id);
}
