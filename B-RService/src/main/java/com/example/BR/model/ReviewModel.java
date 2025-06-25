package com.example.BR.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rating_id;
	
	private Long orderId;
	private int Rating;
	private String Review;
	

}






