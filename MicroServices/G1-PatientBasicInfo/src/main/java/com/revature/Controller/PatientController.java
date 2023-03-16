package com.revature.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Model.BasicPatientInfo;
import com.revature.Service.PatientInfoService;

@RestController
public class PatientController {

	@Autowired
	private PatientInfoService patientInfoService;
	
	@GetMapping("/patient")
	public List<BasicPatientInfo> getall(){
		return patientInfoService.getPatientInfo();
	}
	
	@GetMapping("/patient/{id}")
	public BasicPatientInfo getpatient(@PathVariable int id) {
		return patientInfoService.getPatientById(id);
	}
}
