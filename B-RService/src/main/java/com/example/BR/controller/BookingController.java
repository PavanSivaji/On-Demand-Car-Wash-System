package com.example.BR.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BR.model.BookingModel;
import com.example.BR.service.BookingService;


	@RestController
	@RequestMapping("/order")
	public class BookingController {
		
		@Autowired
		
		
		private BookingService bookingService;
		
		@PostMapping("/request")
		public BookingModel create(@RequestBody BookingModel booking) {
			return bookingService.add(booking);
		}
		
		@GetMapping("/pending")
		public List<BookingModel> get(){
			return bookingService.get();
		}
		
		@PutMapping("/{id}")
		public BookingModel updateOrder(@PathVariable Long id,@RequestBody BookingModel booking) {
			BookingModel change =  bookingService.getOne(id);
			change.setOrderStatus(booking.getOrderStatus());
			change.setWashStatus(booking.getWashStatus());
			change.setWid(booking.getWid());
			return bookingService.add(change);
		}
		@GetMapping("/{id}")
		public BookingModel getDetails(@PathVariable Long id){
			return bookingService.getOne(id);
		}
		@GetMapping("/all/{id}")
		public List<BookingModel> getAll(@PathVariable Long id){
			return bookingService.getall(id);
		}
		
		
	}
	






