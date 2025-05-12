package com.example.washerservice.controller;

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

import com.example.washerservice.model.WasherModel;
import com.example.washerservice.service.WasherService;

@RestController
@RequestMapping("/washer")
public class WasherController {
	
	@Autowired 
	private WasherService washerService;
	
	@PostMapping
	public WasherModel create(@RequestBody WasherModel washerModel) {
		return washerService.add(washerModel);
	}
	@GetMapping
	public List<WasherModel> getAll(){
		return washerService.get();
	}
	@GetMapping("/{id}")
	public  WasherModel getAll(@PathVariable Long id){
		return washerService.getOne(id);
	}
	
	@PutMapping("/{id}")
	public WasherModel updateWasher(@PathVariable Long id,@RequestBody WasherModel washerModel) {
		WasherModel change =  washerService.getOne(id);
		
		
		
		change.setWname(washerModel.getWname());
		change.setWphonenumber(washerModel.getWphonenumber());
		change.setWaddress(washerModel.getWaddress());
		change.setWasherNIC(washerModel.getWasherNIC());
		change.setWsalary(washerModel.getWsalary());
		change.setWage(washerModel.getWage());
		return washerService.add(change);
		
	}
	@DeleteMapping("delete/{id}")
	public String removewasher(@PathVariable Long id) {
		WasherModel washer = washerService.getOne(id);
	    washerService.delete(washer);
	    return "Washer deleted Successfully";
	}

}
