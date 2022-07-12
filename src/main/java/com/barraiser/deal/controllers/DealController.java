package com.barraiser.deal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.barraiser.deal.dto.DealRequestDTO;
import com.barraiser.deal.services.DealService;

@Controller
public class DealController {
	
	
	@Autowired
	private DealService dealService;
	
	
	public String createDeal(DealRequestDTO dealRequestDTO) {
		String response;
		
		//valid the input
		if( isDealValid(dealRequestDTO) ) {
			response = dealService.createDeal(dealRequestDTO);
		} else {
			response = "please check request carefully";
		}
		
		return response;
	}
	
	public String fetchDeal(long dealId) throws Exception {
		return dealService.fetchDeal(dealId);
	}
	
	public void endDeal(long dealId) throws Exception{
		dealService.endDeal(dealId);
	}
	
	private boolean isDealValid(DealRequestDTO dealRequestDTO) {
		//quantity should be more than 0
		//price should be more than 0
		//dealTime should be mora thean 0
		return true;
	}

}
