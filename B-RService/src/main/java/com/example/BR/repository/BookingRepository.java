package com.example.BR.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BR.model.BookingModel;

@Repository
public interface BookingRepository extends JpaRepository<BookingModel, Long> {

	List<BookingModel> findByOrderStatus(String orderStatus);
	List<BookingModel> findByUid(long uid);

}

