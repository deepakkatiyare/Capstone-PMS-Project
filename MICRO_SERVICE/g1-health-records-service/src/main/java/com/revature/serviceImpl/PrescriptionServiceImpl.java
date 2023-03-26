package com.revature.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entity.Prescription;
import com.revature.entity.VisitDetails;
import com.revature.exception.VisitNotFound;
import com.revature.payload.PrescriptionDto;
import com.revature.repository.PrescriptionRepository;
import com.revature.repository.VisitRepository;
import com.revature.service.PrescriptionService;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

	@Autowired
	private PrescriptionRepository prescriptionRepository;

	@Autowired
	private VisitRepository visitRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<PrescriptionDto> getPrescriptionDetails(int visitId) {
		VisitDetails v = visitRepository.findById(visitId)
				.orElseThrow(() -> new VisitNotFound(String.format("Visit Id %d not found", visitId)));
		List<Prescription> medicines = prescriptionRepository.findAllByVisitId(v);
		return medicines.stream().map(medicine -> modelMapper.map(medicine, PrescriptionDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public PrescriptionDto saveVisit(int visitId, PrescriptionDto prescriptionDto) {
		VisitDetails v = visitRepository.findById(visitId)
				.orElseThrow(() -> new VisitNotFound(String.format("Visit id %d not found", visitId)));
		Prescription medicine = modelMapper.map(prescriptionDto, Prescription.class);
		medicine.setVisitId(v);
		Prescription savedMedicine = prescriptionRepository.save(medicine);
		return modelMapper.map(savedMedicine, PrescriptionDto.class);
	}

	@Override
	public PrescriptionDto updatePrescription(PrescriptionDto prescriptionDto, int prescriptionId) {
		Prescription p = prescriptionRepository.findById(prescriptionId).get();
		p.setPrescriptionName(prescriptionDto.getPrescriptionName());
		p.setDosage(prescriptionDto.getDosage());
		p.setPrescriptionNotes(prescriptionDto.getPrescriptionNotes());
		prescriptionRepository.saveAndFlush(p);
		return modelMapper.map(p, PrescriptionDto.class);
	}

	@Override
	public void deletePrescription(int prescriptionId) {
		prescriptionRepository.deleteById(prescriptionId);

	}

}
