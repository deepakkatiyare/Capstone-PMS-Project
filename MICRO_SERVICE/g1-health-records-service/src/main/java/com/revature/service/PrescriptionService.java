package com.revature.service;

import java.util.List;

import com.revature.entity.Prescription;
import com.revature.payload.PrescriptionDto;

public interface PrescriptionService {
	
	public PrescriptionDto saveVisit(int visitId, PrescriptionDto prescriptionDto);
	
	public List<PrescriptionDto> getPrescriptionDetails(int visitId);
	
	public PrescriptionDto updatePrescription(PrescriptionDto prescriptionDto, int prescriptionId);
	
	public void deletePrescription(int prescriptionId);
}