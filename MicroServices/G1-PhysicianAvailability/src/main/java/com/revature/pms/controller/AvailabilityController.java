package com.revature.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pms.model.PhysicianAvailability;
import com.revature.pms.service.PhysicianAvailabiltiyService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("api/v1")
public class AvailabilityController {
	
	@Autowired
	private PhysicianAvailabiltiyService service;
	
	@GetMapping("/physician-available")
	public List<PhysicianAvailability> getPhysiciansService(){
		return  service.getPhysicians();
	}	
	@GetMapping("/physician-available?available=true")
	public List<PhysicianAvailability> getAvailablePhysiciansService(@RequestParam(name = "available") boolean isAvailable){
		return service.getAvailablePhysicians(isAvailable);
	}
	
	@PostMapping("/add-availability")
	public PhysicianAvailability addPhysicianAvailabilityService(@RequestBody PhysicianAvailability availability) {
		return service.addPhysicianAvailability(availability);
	}
		
	@PutMapping("/update-availability")
	public PhysicianAvailability updatePhysicianAvailabilityService(@RequestBody PhysicianAvailability availability){
		 return service.updatePhysicianAvailability(availability);
	}
	
	@DeleteMapping("/physician-available/{email}")
	@Transactional
	public String getPhysicianAvailabilitServiceyById(@PathVariable String email) {
		return service.deletePhysicianAvailabilityById(email);
	}
	
}
