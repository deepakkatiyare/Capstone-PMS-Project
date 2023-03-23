package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import com.revature.entity.dto.AllergyDto;
import com.revature.service.AllergyService;

@RestController
@EnableDiscoveryClient
@RequestMapping("/api/v1")
public class AllergyController {
	
	@Autowired
	private AllergyService allergyService;
	
	@GetMapping("/allergy")
	public ResponseEntity<List<AllergyDto>> getAllAllergies(){
		return new ResponseEntity<>(allergyService.allAllergies(),HttpStatus.OK);
	}
	
	@GetMapping("/allergy/{id}")
	public ResponseEntity<AllergyDto> getAllergy(@PathVariable int id){
		return new ResponseEntity<>(allergyService.getAllergyById(id),HttpStatus.OK);
	}
}
