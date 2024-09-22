package com.example.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.order.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

}
