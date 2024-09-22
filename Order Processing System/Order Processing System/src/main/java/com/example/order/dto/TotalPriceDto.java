package com.example.order.dto;

import java.math.BigDecimal;

public class TotalPriceDto {

	private int id;
	private BigDecimal total_value;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal gettotal_value() {
		return total_value;
	}
	public void settotal_value(BigDecimal total_value) {
		this.total_value = total_value;
	}
	public TotalPriceDto(int id, BigDecimal total_value) {
		super();
		this.id = id;
		this.total_value = total_value;
	}
	
	
}
