package com.barraiser.deal.services;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barraiser.deal.controllers.DealEntity;
import com.barraiser.deal.dto.DealRequestDTO;
import com.barraiser.deal.repositories.DealRepository;

@Service
public class DealService {
	
	
	@Autowired
	private DealRepository dealRepository;
	
	
	//create a deal
	public String createDeal(DealRequestDTO dealRequestDTO) {
		
		String response = "deal created successfully";
		
		DealEntity dealEntity = new DealEntity();
		dealEntity.itemId = dealRequestDTO.itemId;
		dealEntity.name = dealRequestDTO.name;
		dealEntity.price = dealRequestDTO.price;
		dealEntity.endTime = getEndTime(dealRequestDTO.dealTime);
		dealEntity.quantity = dealRequestDTO.quantity;
		dealEntity.createdAt = getCurrentTime();
		dealEntity.updatedAt = getCurrentTime();
		
		dealEntity.createdBy = 1;
		dealRepository.saveAndFlush(dealEntity);
		
		return response;
	}
	
	//fetch a deal
	public String fetchDeal(long dealId) throws Exception {
		Optional<DealEntity> dealEntityOptional = dealRepository.findById(dealId);
		
		if( !dealEntityOptional.isPresent() ) {
			throw new Exception("no deal find");
		}
		
		DealEntity entity = dealEntityOptional.get();
		
		if( ! entity.endTime.before(getCurrentTime()) ) {
			throw new Exception("deal is expired");
		}
		
		if( entity.usedQuantity >= entity.quantity ) {
			throw new Exception("deal is exhausted");
		}
		
		//check if user have made order orders table
		
		claimDeal(entity);
		return entity.name;
		
	}
	
	public void claimDeal(DealEntity dealEntity) {
		dealEntity.usedQuantity +=1;
		dealRepository.saveAndFlush(dealEntity);
		
		//adding into orders table
	}
	
	public void endDeal(long dealId) throws Exception {
		Optional<DealEntity> dealEntityOptional = dealRepository.findById(dealId);
		if( !dealEntityOptional.isPresent() ) {
			throw new Exception("no deal find");
		}
		
		DealEntity entity = dealEntityOptional.get();
		
		entity.endTime = getCurrentTime();
		dealRepository.saveAndFlush(entity);
	}
	
	
	private Date getCurrentTime() {
		return Calendar.getInstance().getTime();
	}
	
	private Date getEndTime(long minutes) {
		Calendar currentTimeNow = Calendar.getInstance();
		currentTimeNow.add(Calendar.MINUTE, (int)minutes);
		return currentTimeNow.getTime();
	}

}
