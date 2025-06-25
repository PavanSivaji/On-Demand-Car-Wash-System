package com.example.BR.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.BR.model.ReviewModel;
import com.example.BR.service.RatingService;

@RestController
@RequestMapping("/review")
public class RatingController {
	@Autowired
	RatingService ratingService;
	
	@PostMapping("/post")
	public ReviewModel postfeedback(@RequestBody ReviewModel rr) {
		return ratingService.add(rr);
	}
	
	@GetMapping("/{id}")
		public ReviewModel getFeedbackdetails(@PathVariable Long id){
			return ratingService.getOne(id);
		
		
	}

}
