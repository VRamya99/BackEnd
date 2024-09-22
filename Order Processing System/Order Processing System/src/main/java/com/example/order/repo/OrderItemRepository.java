package com.example.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.order.entity.OrderItemsEntity;

public interface OrderItemRepository extends JpaRepository<OrderItemsEntity, Integer> {

}
