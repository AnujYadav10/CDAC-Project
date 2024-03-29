package com.app.service;

import java.util.List;

import javax.validation.Valid;

import com.app.dto.ManagerDTO;
import com.app.entities.Manager;



public interface ManagerService {

	ManagerDTO getmanbyid(Long manid); 
	ManagerDTO findbyemail(String email);
	ManagerDTO addmanager(Manager man);
	
}
