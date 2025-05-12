package com.example.BR.service.impl;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BR.model.BookingModel;
import com.example.BR.repository.BookingRepository;
import com.example.BR.service.BookingService;



@Service 
public class BookingServiceImpl implements BookingService {
	
	private static Logger logger= LoggerFactory.getLogger(BookingServiceImpl.class);
	
	@Autowired 
	BookingRepository bookingRepository;
	
	public BookingServiceImpl(BookingRepository bookingRepository) {
		super();
		this.bookingRepository = bookingRepository;
	}

	@Override
	public BookingModel add(BookingModel booking) {
		logger.info("Car Wash Order Placed Successfully {}",booking);
		
		try {
			if(booking.getOrderStatus()==null) {
				booking.setOrderStatus("Pending");
			}
			if(booking.getWashStatus()==null) {
				booking.setWashStatus("Pending");
			}
			BookingModel savedOrder = bookingRepository.save(booking);
			logger.info("Car Wash Order Placed Successfully : {}",savedOrder);
			return savedOrder;
		}catch(Exception e) {
			logger.error("Error occurred while requesting car wash: {}", e.getMessage(), e);
			return null;
		}
		
		
	}

	@Override
	public List<BookingModel> get() {
		logger.info("Fetching all Pending Orders");
		try {
			List<BookingModel> orderList=bookingRepository.findByOrderStatus("pending");
			return orderList;
		}catch(Exception e) {
			logger.error("Error while fetching Pending Orders: {}", e.getMessage(),e);
			return null;
		}
		
	}

	@Override
	public BookingModel getOne(Long orderid) {
		logger.info("fetching Order Details with Order id : {}",orderid);
		try {
			BookingModel booking=bookingRepository.findById(orderid).orElseThrow();
			logger.info("Fetched Order Details: {}",booking);
			return booking;
		}catch (Exception e) {
			logger.error("Error occurred while fetching Order Details with order id {}", orderid, e.getMessage(), e);
			return null;
		}
		
	}

	@Override
	public List<BookingModel> getall(long uid) {
		logger.info("Fetching all orders with User id: {}",uid);
		try {
			List<BookingModel> orderList=bookingRepository.findByUid(uid);
			 return orderList;
		}catch(Exception e) {
			logger.error("Error occurred while fetching all Orders with user id {}", uid, e.getMessage(), e);
			return null;
		}
		
	}

	@Override
	public void cancel(BookingModel booking) {
		logger.info("Request received to cancel order: {}", booking);
		try {
			bookingRepository.delete(booking);
			logger.info("order cancelled successfully: {}", booking);
			}catch (Exception e) {
				logger.error("Error occurred while cancelling order: {}", e.getMessage(), e);
			}
		
		
	}

	
}