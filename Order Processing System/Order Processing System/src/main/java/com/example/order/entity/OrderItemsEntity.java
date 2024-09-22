package com.example.order.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="order_items")
public class OrderItemsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="product_id",nullable = false)
	private int productId;
	@Column(name="quantity",nullable = false)
	private int quantity;
	@Column(name="price",nullable = false)
	private BigDecimal price; 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
	private OrderEntity order;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public OrderEntity getOrder() {
		return order;
	}
	public void setOrder(OrderEntity order) {
		this.order = order;
	}
	public OrderItemsEntity(int productId, int quantity, BigDecimal price, OrderEntity order) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.order = order;
	}
	public OrderItemsEntity() {
		super();
	}
	
	
}
