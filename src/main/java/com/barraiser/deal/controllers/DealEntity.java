package com.barraiser.deal.controllers;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;



@Table( name = "deals" )
@Entity
@Data
@Builder
public class DealEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long dealId;
	
	public long itemId;
	
	public String name;
	
	public double price;
	
	public int usedQuantity;
	
	public int quantity;
	
	public Date endTime;
	
	public Date createdAt;
	
	public Date updatedAt;
	
	public long createdBy;
	
	public long updatedBy;

}
