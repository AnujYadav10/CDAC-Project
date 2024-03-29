package com.app.controller;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Manager;
import com.app.service.ManagerService;
import com.app.service.ManagerServiceImp;


@RestController
@RequestMapping("/manager")
@Validated
public class ManagerController {
	
	@Autowired
	private ManagerServiceImp managerService;
		
	@GetMapping("/{email}")
	public ResponseEntity<?> getmanagerbyid(@PathVariable String email){
		System.out.println("recieved email " + email );
		return ResponseEntity.ok(managerService.findbyemail(email));
	}
	

	
	@PostMapping
	public ResponseEntity<?> addmanager(@RequestBody Manager man){
		
		System.out.println("Manager receved " + man);
		return ResponseEntity.status(HttpStatus.CREATED).body(managerService.addmanager(man));
		
	}
	
}
