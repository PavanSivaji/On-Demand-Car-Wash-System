package com.example.BR.service;


import com.example.BR.model.ReviewModel;

public interface RatingService {
	ReviewModel add(ReviewModel rr);
	ReviewModel getOne(Long orderId);

}
