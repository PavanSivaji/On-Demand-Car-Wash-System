package com.example.user.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.user.model.UserModel;
import com.example.user.repository.UserRepository;
import com.example.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserModel add(UserModel userModel) {
		logger.info("Request recieved to add User: {}", userModel);
		
		try {
			UserModel savedUser = userRepository.save(userModel);
			logger.info("WasherModel added successfully: {}", savedUser);
			return savedUser;
		} catch (Exception e) {
			logger.error("Error occurred while adding User: {}", e.getMessage(), e);
			return null;
		}
	}

	@Override
	public List<UserModel> get() {
		logger.info("Fetching all User entries");
		try {
			List<UserModel> userList = userRepository.findAll();
			logger.info("Fetched {} UserRepository entries", userList.size());
			return userList;
		} catch (Exception e) {
			logger.error("Error occurred while fetching User entries: {}", e.getMessage(), e);
			return null;
		}
	}

	@Override
	public UserModel getOne(Long id) {
		logger.info("Fetching User entry with id: {}", id);
		try {
			UserModel user = userRepository.findById(id).orElseThrow();
			logger.info("Fetched user entry: {}", user);
			return user;
		} catch (Exception e) {
			logger.error("Error occurred while fetching User with id {}: {}", id, e.getMessage(), e);
			return null;
		}
	}

	@Override
	public void delete(UserModel user) {
		logger.info("Request received to delete User: {}", user);
		try {
			userRepository.delete(user);
			logger.info("User deleted successfully: {}", user);
		} catch (Exception e) {
			logger.error("Error occurred while deleting User: {}", e.getMessage(), e);
		}
	}
}