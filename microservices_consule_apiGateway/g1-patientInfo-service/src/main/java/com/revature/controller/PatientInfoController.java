package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entity.dto.PatientDto;
import com.revature.service.PatientInfoService;

@RestController
@EnableDiscoveryClient
@RequestMapping("/api/v1")
public class PatientInfoController {

	@Autowired
	PatientInfoService patientService;

	@GetMapping("/patient")
	public ResponseEntity<List<PatientDto>> getPatients() {
		return new ResponseEntity<>(patientService.getAllPatients(), HttpStatus.OK);
	}

	@GetMapping("/patient/{id}")
	public ResponseEntity<PatientDto> getPatientById(@PathVariable("id") int id) {
		return new ResponseEntity<>(patientService.getPatientById(id), HttpStatus.OK);
	}

	@PutMapping("/patient/{id}")
	public ResponseEntity<PatientDto> putPatient(@PathVariable("id") int id,
			@RequestBody PatientDto patientDto) {
		return new ResponseEntity<>(patientService.updatePatientById(id, patientDto), HttpStatus.OK);
	}
}
