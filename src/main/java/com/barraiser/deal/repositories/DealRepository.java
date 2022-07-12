package com.barraiser.deal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barraiser.deal.controllers.DealEntity;


@Repository
public interface DealRepository extends JpaRepository<DealEntity, Long> {
	
	

}
