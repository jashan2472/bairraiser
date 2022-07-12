package com.barraiser.deal.dto;

import lombok.Data;

@Data
public class DealRequestDTO {
		
	public Long itemId;
	
	public Double price;
	
	public Integer quantity;
	
	//time in minutes
	public Long dealTime;
	
	public String name;

}
