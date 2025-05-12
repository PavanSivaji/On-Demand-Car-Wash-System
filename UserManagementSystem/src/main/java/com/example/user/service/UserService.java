package com.example.user.service;

import java.util.List;

import com.example.user.model.UserModel;

public  interface UserService {
	
	UserModel add(UserModel userModel);
	List<UserModel> get();
	UserModel getOne(Long id);
	void delete(UserModel user);

	
}


