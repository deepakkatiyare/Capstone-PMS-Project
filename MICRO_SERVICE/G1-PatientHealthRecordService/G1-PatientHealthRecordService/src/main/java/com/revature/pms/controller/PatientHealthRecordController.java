package com.revature.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pms.model.PatientHealthRecordModal;
import com.revature.pms.repo.PatientHealthRecordRepository;
import com.revature.pms.service.PatientHealthRecordService;

@RestController
public class PatientHealthRecordController {
	
	@Autowired
	PatientHealthRecordService patientService;
	
	@PostMapping("/patient")
	public PatientHealthRecordModal addPatient(@RequestBody PatientHealthRecordModal patient)
	{
		return patientService.savePatient(patient);
	}
	@GetMapping("/patient/{id}")
	public PatientHealthRecordModal findById(@PathVariable int id)
	{
		return patientService.getPatientById(id);
	}
	
	@PutMapping("/patient/{id}")
	public PatientHealthRecordModal updatePatient(@RequestBody PatientHealthRecordModal patient,@PathVariable int id)
	{
		return patientService.updatePatient(patient,id);
	}
	
}
	
