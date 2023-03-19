package com.revature.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.revature.pms.model.PatientHealthRecordModal;
import com.revature.pms.repo.PatientHealthRecordRepository;

@Service
public class PatientHealthRecordService {

	@Autowired
	private PatientHealthRecordRepository patientRepo;
	
	//post
	public PatientHealthRecordModal savePatient(PatientHealthRecordModal patient)
	{
		return patientRepo.save(patient);
	}
	
	//get
	public PatientHealthRecordModal getPatientById(int id)
	{
		return patientRepo.findById(id).orElse(null);
	}
	
	//put
	public PatientHealthRecordModal updatePatient(PatientHealthRecordModal patient,int id)
	{
		PatientHealthRecordModal existingPatient=patientRepo.findById(id).orElse(null);
		existingPatient.setAllergyId(patient.getAllergyId());
		
		//remaining 9 
		
		return patientRepo.save(existingPatient);
	}
}
