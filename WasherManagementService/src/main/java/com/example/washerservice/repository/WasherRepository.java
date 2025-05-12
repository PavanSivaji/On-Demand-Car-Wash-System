package com.example.washerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.washerservice.model.WasherModel;

@Repository
public interface WasherRepository extends JpaRepository<WasherModel, Long> {

}
