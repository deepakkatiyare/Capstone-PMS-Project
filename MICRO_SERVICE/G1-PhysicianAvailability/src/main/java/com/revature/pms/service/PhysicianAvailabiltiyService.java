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
	public long count() {
		return repo.count();
	}
	public List<PhysicianAvailability> getAvailablePhysicians(boolean isAvailable){
		return repo.findByIsAvailable(isAvailable);
	}
	
	public PhysicianAvailability addPhysicianAvailability(PhysicianAvailability availability) {
		return repo.save(availability);
	}
	
	public void schedulePhysician(String startDate,String endDate,String email) {
		repo.updateStartAndEndDate(startDate, endDate, email);
	}
	
	public PhysicianAvailability update(PhysicianAvailability update) {
		return repo.save(update);
	}
	public String deletePhysicianAvailabilityById(String email) {
		return repo.deleteByEmail(email);
	}
}
