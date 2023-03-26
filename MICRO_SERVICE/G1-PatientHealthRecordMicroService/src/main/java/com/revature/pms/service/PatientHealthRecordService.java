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
		existingPatient.setPatientId(patient.getPatientId());
		existingPatient.setHeight(patient.getHeight());
		existingPatient.setWeight(patient.getBloodPressureSystolic());
		existingPatient.setBloodPressureSystolic(patient.getBloodPressureSystolic());
		existingPatient.setBloodPressureDiastolic(patient.getBloodPressureDiastolic());
		existingPatient.setBodyTemperature(patient.getBodyTemperature());
		existingPatient.setRespirationRate(patient.getRespirationRate());
		existingPatient.setBloodGroup(patient.getBloodGroup());
		existingPatient.setNurseEmail(patient.getNurseEmail());
		existingPatient.setPhysicianEmail(patient.getPhysicianEmail());
		existingPatient.setAppointmentId(patient.getAppointmentId());
		existingPatient.setKeyNotes(patient.getKeyNotes());
		existingPatient.setAllergyId(patient.getAllergyId());		
		return patientRepo.save(existingPatient);
	}
}
