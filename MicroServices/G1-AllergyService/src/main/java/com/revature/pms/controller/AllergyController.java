package com.revature.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pms.model.Allergy;
import com.revature.pms.service.AllergyService;

@RestController
//@ResponseBody
public class AllergyController {
	
	@Autowired
	private AllergyService allergyService;
	
	@GetMapping("/allergy")
	public List<Allergy> getAll(){
		return allergyService.getAllergies();
	}
	
	@GetMapping("/allergy/{id}")
	public Allergy getAllergy(@PathVariable int id){
		return allergyService.getAllergy(id);
	}
}
