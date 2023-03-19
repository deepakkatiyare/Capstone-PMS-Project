package com.revature.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.pms.entity.PhysicianAvailability;
import com.revature.pms.repo.PhysicianAvailabilityRepo;

@Service
public class PhysicianAvailabiltiyService {
	@Autowired
	private PhysicianAvailabilityRepo repo;
	
	public List<PhysicianAvailability> getPhysicians(){
		return  repo.findAll();
	}	
	public List<PhysicianAvailability> getAvailablePhysicians(boolean isAvailable){
		return repo.findByIsAvailable(isAvailable);
	}
	
	public PhysicianAvailability addPhysicianAvailability(PhysicianAvailability availability) {
		return repo.save(availability);
	}
	public PhysicianAvailability updatePhysicianAvailability(PhysicianAvailability availability){
		return repo.save(availability);
	}
	public String deletePhysicianAvailabilityById(String email) {
		return repo.deleteByEmail(email);
	}
}
