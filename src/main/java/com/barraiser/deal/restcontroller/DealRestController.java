package com.barraiser.deal.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barraiser.deal.controllers.DealController;
import com.barraiser.deal.dto.DealRequestDTO;

@RestController
public class DealRestController {
	
	@Autowired
	private DealController dealController;
	
	@PostMapping( "/deal" )
	public String createDeal( @RequestBody DealRequestDTO dealRequestDTO ) {
		String response;
		try {
			response = dealController.createDeal(dealRequestDTO);
		} catch (Exception e) {
			response = "please try again";
		}
		
		return response;
	}
	
	
	@PostMapping( "/claim/{dealId}" )
	public String claimDeal( @RequestParam("dealId") long dealId ) {
		
		String response;
		try {
			response = dealController.fetchDeal(dealId);
		} catch (Exception e) {
			response = e.getMessage();
		}
		
		return response;
		
	}
	
	@PatchMapping( "/deal" )
	public String endDeal( @RequestParam("dealId") long dealId ) {
		String response = "deal is deleted";
		try {
			dealController.endDeal(dealId);
		} catch (Exception e) {
			response = e.getMessage();
		}
		
		return response;
	}
	

}
