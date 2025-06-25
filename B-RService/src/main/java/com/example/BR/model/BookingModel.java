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
public class BookingModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	private String cname;
	private long cphonenumber;
	private int scapacity;
	private String carmodel;
	private String location;
	private String time;
	private String orderStatus;
	private String washStatus;
	private long wid;
	private long uid;	
	
	
	
	
	
	
	

}
