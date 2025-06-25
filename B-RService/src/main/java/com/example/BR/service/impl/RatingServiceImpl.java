package com.example.BR.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BR.model.ReviewModel;
import com.example.BR.repository.ReviewRepository;
import com.example.BR.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{
    
	
	private static Logger logger= LoggerFactory.getLogger(RatingServiceImpl.class);
	
	@Autowired
	ReviewRepository ratingRepo;
	
	
	
	
	public RatingServiceImpl(ReviewRepository ratingRepo) {
		super();
		this.ratingRepo = ratingRepo;
	}

	@Override
	public ReviewModel add(ReviewModel rr) {
		logger.info("Rated the car wash service successfully {}",rr);
		try {
		ReviewModel savedRating= ratingRepo.save(rr);
		logger.info("Rated the car wash service successfully {}",rr);
		return savedRating;
		}catch(Exception e) {
			logger.error("Error while rating the service: {}", e.getMessage(),e);
			return null;
		}
	}

	@Override
	public ReviewModel getOne(Long orderId) {
		logger.info("fetching Rating and Review with Order id : {}",orderId);
		try {
			ReviewModel rr=ratingRepo.findById(orderId).orElseThrow();
			logger.info("Fetched Rating and Review : {}",rr);
			return rr;
		}catch (Exception e) {
			logger.error("Error occurred while fetching Rating and Review with order id {}", orderId, e.getMessage(), e);
			return null;
		}
		
	}
}

	



