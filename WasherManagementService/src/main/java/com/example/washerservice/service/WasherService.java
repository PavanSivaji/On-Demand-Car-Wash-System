package com.example.washerservice.service;

import java.util.List;

import com.example.washerservice.model.WasherModel;

public interface WasherService {
	WasherModel add(WasherModel washerModel);
	List<WasherModel> get();
	WasherModel getOne(Long id);
	void delete(WasherModel washer);
	
	
	

}
