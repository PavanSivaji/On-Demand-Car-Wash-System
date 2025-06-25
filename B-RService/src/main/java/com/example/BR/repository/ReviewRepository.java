package com.example.BR.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.BR.model.ReviewModel;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewModel, Long> {

	

}
