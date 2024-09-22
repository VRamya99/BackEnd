package com.example.order.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "user_id",nullable = false)
	private int userId;
	@Column(name="total_price")
	private BigDecimal totalPrice;
	@CreationTimestamp
	@Column(name="created_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private LocalDateTime createDateTime;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<OrderItemsEntity> orderItems;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}
	public List<OrderItemsEntity> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItemsEntity> orderItems) {
		this.orderItems = orderItems;
	}
	public OrderEntity(int userId, BigDecimal totalPrice, LocalDateTime createDateTime,
			List<OrderItemsEntity> orderItems) {
		super();
		
		this.userId = userId;
		this.totalPrice = totalPrice;
		this.createDateTime = createDateTime;
		this.orderItems = orderItems;
	}
	public OrderEntity() {
		super();
	}
	
}
