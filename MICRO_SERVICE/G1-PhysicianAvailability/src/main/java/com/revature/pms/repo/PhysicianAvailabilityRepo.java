package com.revature.pms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.pms.entity.PhysicianAvailability;

public interface PhysicianAvailabilityRepo extends JpaRepository<PhysicianAvailability,String> {

	public List<PhysicianAvailability> findByIsAvailable(boolean isAvailable);
	
    public String deleteByEmail(String email);
	
}	
