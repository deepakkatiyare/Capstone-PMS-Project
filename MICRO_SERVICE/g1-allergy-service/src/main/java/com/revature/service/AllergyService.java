package com.revature.service;

import java.util.List;

import com.revature.entity.Allergy;
import com.revature.entity.dto.AllergyDto;
public interface AllergyService {

	public List<AllergyDto> allAllergies();
	
	public AllergyDto getAllergyById(int id);
}
