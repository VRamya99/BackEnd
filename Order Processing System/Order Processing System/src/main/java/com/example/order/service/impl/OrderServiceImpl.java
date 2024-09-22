package com.example.order.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.order.dto.TotalPriceDto;
import com.example.order.entity.OrderEntity;
import com.example.order.entity.OrderItemsEntity;
import com.example.order.exception.OrderNotFoundException;
import com.example.order.repo.OrderRepository;
import com.example.order.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService{
	
	private OrderRepository orderRepository;
	
	OrderServiceImpl(OrderRepository orderRepository){
		this.orderRepository=orderRepository;
	}
	@Override
	public String createOrder(OrderEntity order) {
		
		order.setOrderItems(order.getOrderItems());
		BigDecimal total_value=BigDecimal.ZERO;
		if(order.getOrderItems()!=null) {
		for(OrderItemsEntity item:order.getOrderItems())
		{  item.setOrder(order);
			BigDecimal productValue=BigDecimal.valueOf(item.getQuantity()).multiply(item.getPrice());
			 total_value = total_value.add(productValue);
		}
		
		}order.setTotalPrice(total_value);
		orderRepository.save(order);
		return "new Order created successfully";
	}

	@Override
	public String addItemsToOrder(int id, List<OrderItemsEntity> orderItems) {
		OrderEntity order=orderRepository.findById(id).orElseThrow(()->new OrderNotFoundException("order with id "+id+" not found"));
		
			
			BigDecimal total_value=BigDecimal.ZERO;
			total_value=total_value.add(order.getTotalPrice());
			for(OrderItemsEntity item:orderItems)
			{  item.setOrder(order);
				BigDecimal productValue=BigDecimal.valueOf(item.getQuantity()).multiply(item.getPrice());
				 total_value = total_value.add(productValue);
			}
			
			 order.setOrderItems(orderItems);
		        order.setTotalPrice(total_value); 
		        orderRepository.save(order);
			return "Items added to order successfully";
		
		
	}

	@Override
	public BigDecimal getTotalPrice(int id) {
		BigDecimal total_value=BigDecimal.ZERO;
		OrderEntity order=orderRepository.findById(id).orElseThrow(()->new OrderNotFoundException("order with id "+id+" not found"));
		
		List<OrderItemsEntity> items=order.getOrderItems();
		total_value=getTotoalValue(items, total_value);
		return total_value;
		
	}
	
	public BigDecimal getTotoalValue(List<OrderItemsEntity> orderItems,BigDecimal total_value)
	{
		for(OrderItemsEntity item:orderItems)
		{
			
			BigDecimal productValue=BigDecimal.valueOf(item.getQuantity()).multiply(item.getPrice());
			 total_value = total_value.add(productValue);
		}
		return total_value;
	}
	

}
