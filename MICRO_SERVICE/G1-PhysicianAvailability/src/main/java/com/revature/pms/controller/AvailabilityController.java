package com.revature.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pms.entity.PhysicianAvailability;
import com.revature.pms.service.PhysicianAvailabiltiyService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("api/v1")
public class AvailabilityController {
	
	@Autowired
	private PhysicianAvailabiltiyService service;
	
	@GetMapping("/physician")
	public ResponseEntity<List<PhysicianAvailability>> getPhysiciansService(){
		List<PhysicianAvailability> availabilities = service.getPhysicians();
		if(availabilities==null)
			return new ResponseEntity<List<PhysicianAvailability>>(HttpStatus.INTERNAL_SERVER_ERROR);
		else if(availabilities.isEmpty())
			return new ResponseEntity<List<PhysicianAvailability>>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<PhysicianAvailability>>(availabilities, HttpStatus.OK);
	}	
	@GetMapping("/physician-available")
	public ResponseEntity<List<PhysicianAvailability>> getAvailablePhysiciansService(@RequestParam(name = "available") boolean available){
		List<PhysicianAvailability> availabilities =  service.getAvailablePhysicians(available);
		if(availabilities==null)
			return new ResponseEntity<List<PhysicianAvailability>>(HttpStatus.INTERNAL_SERVER_ERROR);
		else if(availabilities.isEmpty())
			return new ResponseEntity<List<PhysicianAvailability>>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<PhysicianAvailability>>(availabilities, HttpStatus.OK);

	}	
	@PostMapping("/add-availability")
	public ResponseEntity<PhysicianAvailability> addPhysicianAvailabilityService(@RequestBody PhysicianAvailability availability) {
		PhysicianAvailability available = service.addPhysicianAvailability(availability);
		if(available==null)
			return new ResponseEntity<PhysicianAvailability>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		return new ResponseEntity<PhysicianAvailability>(available,HttpStatus.CREATED);
	}	
	@PutMapping("/update-availability")
	public ResponseEntity<PhysicianAvailability> updatePhysicianAvailabilityService(@RequestBody PhysicianAvailability availability){ 
		PhysicianAvailability available = service.updatePhysicianAvailability(availability);
		if(available==null)
			return new ResponseEntity<PhysicianAvailability>(HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<PhysicianAvailability>(available,HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/physician-available/{email}")
	@Transactional
	public ResponseEntity<String> getPhysicianAvailabilitServiceyById(@PathVariable String email) {
		String status = service.deletePhysicianAvailabilityById(email);
		if(Integer.parseInt(status)==0)
			return new ResponseEntity<String>(status,HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<String>(status,HttpStatus.ACCEPTED);
	}
}
