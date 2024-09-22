package com.example.demo.Dto;

import java.math.BigDecimal;

public class TotalValueDto {
	
	private BigDecimal total_inventory_value;

	public BigDecimal getTotal_inventory_value() {
		return total_inventory_value;
	}

	public void setTotal_inventory_value(BigDecimal total_inventory_value) {
		this.total_inventory_value = total_inventory_value;
	}

	public TotalValueDto(BigDecimal total_inventory_value) {
		super();
		this.total_inventory_value = total_inventory_value;
	}

	public TotalValueDto() {
		super();
	}
	

}
