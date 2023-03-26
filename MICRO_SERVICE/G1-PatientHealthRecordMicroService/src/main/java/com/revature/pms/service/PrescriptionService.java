package com.revature.pms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.pms.model.PrescriptionModal;
import com.revature.pms.repo.PrescriptionRepository;

@Service
public class PrescriptionService {
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	public PrescriptionModal addPrescriptionData(PrescriptionModal prescription) {
		return prescriptionRepository.save(prescription);
	}
	public PrescriptionModal getPrescriptionById(int id) {
		return prescriptionRepository.findById(id).orElse(null);
	}
	
}
