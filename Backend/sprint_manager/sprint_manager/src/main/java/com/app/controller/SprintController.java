package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.SprintDTO;
import com.app.entities.Sprint;
import com.app.service.ManagerServiceImp;
import com.app.service.Sprintserviceimp;

@RestController
@RequestMapping("/sprint")
@Validated
public class SprintController {
	
	@Autowired
	private Sprintserviceimp sprintservice;
	

	
	@GetMapping(value = "/manager/{manid}")
	public ResponseEntity<?> getsprintsbymanagerid(@PathVariable Long manid) throws IOException {
		System.out.println(("Manager id receved " + manid));
		return ResponseEntity.ok(sprintservice.getallaprintsfromman(manid));
	}
	
	
	@PostMapping
	public ResponseEntity<?> addnewSprint(@RequestBody  SprintDTO sp) {
		System.out.println("Sprint received " + sp);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(sprintservice.addNewSprint(sp));
	}
	
	
	@PutMapping("/{sprintid}")
	public ResponseEntity<?> updateSprint (@PathVariable Long sprintid , @RequestBody SprintDTO sp) {
		System.out.println("Sprint received " + sp + " with id " + sprintid);
		return ResponseEntity.ok(sprintservice.updateSprint(sprintid, sp));
	}
	
		@DeleteMapping("/{sprintid}")
		public ResponseEntity<?> deleteSprint(@PathVariable Long sprintid) {
			System.out.println("in delete emp " + sprintid);
			return ResponseEntity.ok(sprintservice.deleteSprint(sprintid));
		}		
	
}
