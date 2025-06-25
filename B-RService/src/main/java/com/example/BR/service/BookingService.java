package com.example.BR.service;

import java.util.List;

import com.example.BR.model.BookingModel;

public interface BookingService {
	
	BookingModel add(BookingModel booking);
	
	List<BookingModel> get();
	
	BookingModel getOne(Long orderid);
	
	void cancel(BookingModel booking);
	List<BookingModel> getall(long uid);

	
	
	
	
	
	

}
