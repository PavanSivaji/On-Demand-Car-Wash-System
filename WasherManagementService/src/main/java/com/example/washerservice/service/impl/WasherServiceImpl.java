package com.example.washerservice.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.washerservice.model.WasherModel;
import com.example.washerservice.repository.WasherRepository;
import com.example.washerservice.service.WasherService;

@Service
public class WasherServiceImpl implements WasherService {
	
	private static Logger logger = LoggerFactory.getLogger(WasherServiceImpl.class);
	
	private WasherRepository washerRepository;
	
	public WasherServiceImpl(WasherRepository washerRepository) {
		super();
		this.washerRepository = washerRepository;
	}

	@Override
	public WasherModel add(WasherModel washerModel) {
		logger.info("Request recieved to add Washer: {}", washerModel);
		
		try {
			WasherModel savedWasher = washerRepository.save(washerModel);
			logger.info("WasherModel added successfully: {}", savedWasher);
			return savedWasher;
		} catch (Exception e) {
			logger.error("Error occurred while adding Washer: {}", e.getMessage(), e);
			return null;
		}
	}

		

	@Override
	public List<WasherModel> get() {
		logger.info("Fetching all Washer entries");
		try {
			List<WasherModel> washerList = washerRepository.findAll();
			logger.info("Fetched {} WasherRepository entries", washerList.size());
			return washerList;
		} catch (Exception e) {
			logger.error("Error occurred while fetching Washer entries: {}", e.getMessage(), e);
			return null;
		}
	}

	@Override
	public WasherModel getOne(Long id) {
		logger.info("Fetching Washer entry with id: {}", id);
		try {
			WasherModel washer = washerRepository.findById(id).orElseThrow();
			logger.info("Fetched Washer entry: {}", washer);
			return washer;
		} catch (Exception e) {
			logger.error("Error occurred while fetching Washer with id {}: {}", id, e.getMessage(), e);
			return null;
		}
	}

	@Override
	public void delete(WasherModel washer) {
		logger.info("Request received to delete Washer: {}", washer);
		try {
			washerRepository.delete(washer);
			logger.info("Washer deleted successfully: {}", washer);
		} catch (Exception e) {
			logger.error("Error occurred while deleting Washer: {}", e.getMessage(), e);
		}
	}
}