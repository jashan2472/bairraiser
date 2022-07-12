package com.barraiser.deal.controllers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;



@Table( name = "orders" )
@Entity
@Data
@Builder
public class OrderEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long orderId;
	
	public long dealId;
	
	public long userId;
	
	public boolean isCompleted;

}
