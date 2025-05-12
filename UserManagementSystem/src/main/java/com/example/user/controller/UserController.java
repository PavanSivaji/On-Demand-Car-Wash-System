package com.example.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.model.UserModel;
import com.example.user.service.UserService;

	@RestController
	@RequestMapping("/user")
	public class UserController {
		
		@Autowired 
		private UserService userService;
		
		@PostMapping
		public UserModel create(@RequestBody UserModel userModel) {
			return userService.add(userModel);
		}
		@GetMapping
		public List<UserModel> getAll(){
			return userService.get();
		}
		@GetMapping("/{id}")
		public  UserModel getAll(@PathVariable Long id){
			return userService.getOne(id);
		}
		
		@PutMapping("/{id}")
		public UserModel updateUser(@PathVariable Long id,@RequestBody UserModel userModel) {
			UserModel change =  userService.getOne(id);
			
			
			
			change.setUname(userModel.getUname());
			change.setUserPhoneNumber(userModel.getUserPhoneNumber());
			change.setUemail(userModel.getUemail());
			change.setUaddress(userModel.getUaddress());
			change.setUserNIC(userModel.getUserNIC());
			change.setU_age(userModel.getU_age());
			return userService.add(change);
			
		}
		@DeleteMapping("delete/{id}")
		public String removeUser(@PathVariable Long id) {
			UserModel user = userService.getOne(id);
			userService.delete(user);
		    return "User deleted Successfully";
		}

	}






