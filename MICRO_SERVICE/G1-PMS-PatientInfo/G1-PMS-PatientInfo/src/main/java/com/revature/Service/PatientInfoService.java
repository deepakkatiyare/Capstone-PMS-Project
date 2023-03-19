package com.revature.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Model.BasicPatientInfo;
import com.revature.Repository.PatientRepository;

@Service
public class PatientInfoService {
	
	@Autowired
	private PatientRepository patientRepo;
	
	public List<BasicPatientInfo> getPatientInfo(){
	return patientRepo.findAll();
}

	
	public BasicPatientInfo getPatientById(int id){
		return patientRepo.findById(id).get();
		
		
	}
	
	public BasicPatientInfo updateById(BasicPatientInfo basicpatientinfo, int id) {
		
		BasicPatientInfo basicInfo = patientRepo.findById(id).orElse(null);
		
		basicInfo.setEmail(basicpatientinfo.getEmail());
		basicInfo.setGender(basicpatientinfo.getGender());
		basicInfo.setPatientFirstName(basicpatientinfo.getPatientFirstName());
		basicInfo.setPatientLastName(basicpatientinfo.getPatientLastName());
		
		return patientRepo.saveAndFlush(basicInfo);
			
		
	}
	
}
