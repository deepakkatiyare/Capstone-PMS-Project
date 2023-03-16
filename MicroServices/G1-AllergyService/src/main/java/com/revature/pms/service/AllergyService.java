package com.revature.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.pms.model.Allergy;
import com.revature.pms.repo.AllergyRepository;

@Service
public class AllergyService {
	
	@Autowired
	private AllergyRepository allergyRepository;
	
	public List<Allergy> getAllergies() {
		return allergyRepository.findAll(); 
	}
	public Allergy getAllergy(int id) {
		return allergyRepository.findById(id).get();
	}
}
