package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entity.Prescription;
import com.revature.entity.TestDetails;
import com.revature.entity.VisitDetails;
import com.revature.payload.PrescriptionDto;
import com.revature.payload.TestDto;
import com.revature.payload.VisitDto;
import com.revature.service.PrescriptionService;
import com.revature.service.TestService;
import com.revature.service.VisitService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1")
public class HealthRecordsController {
	@Autowired
	private VisitService visitService;

	@Autowired
	private TestService testService;

	@Autowired
	private PrescriptionService prescriptionService;

	// get visits details
	@GetMapping("/patient/{patientId}/visits")
	public ResponseEntity<List<VisitDto>> getAllVisits(@PathVariable(name = "patientId") int patientId) {
		return new ResponseEntity<>(visitService.getAllVisits(patientId), HttpStatus.OK);

	}

	// save visits
	@PostMapping("/patient/{patientId}/visits")
	public ResponseEntity<VisitDto> saveVisit(@PathVariable(name = "patientId") int patientId,
			@RequestBody VisitDto visitDto) {
		return new ResponseEntity<>(visitService.saveVisit(patientId, visitDto), HttpStatus.CREATED);
	}

	// delete visit
	@DeleteMapping("/visitdetails/{visitid}")
	public ResponseEntity<String> deleteVisit(@PathVariable(name = "visitid") int visitId) {
		visitService.deleteVisit(visitId);
		return new ResponseEntity<>("Visit deleted Successfully", HttpStatus.ACCEPTED);
	}

	// update visit
	@PutMapping("/visitdetails/{visitid}")
	public ResponseEntity<VisitDto> updateAppointment(@RequestBody VisitDto visitDto,
			@PathVariable(name = "visitid") int visitId) {
		return new ResponseEntity<>(visitService.updateVisit(visitDto, visitId), HttpStatus.ACCEPTED);
	}

	// get all test details
	@GetMapping("/visitdetails/{visitId}/tests")
	public ResponseEntity<List<TestDto>> getTestDetails(@PathVariable(name = "visitId") int visitId) {
		return new ResponseEntity<>(testService.getTestDetails(visitId), HttpStatus.OK);

	}

	// save tests
	@PostMapping("/visitdetails/{visitId}/Tests")
	public ResponseEntity<TestDto> saveTest(@PathVariable(name = "visitId") int visitId, @RequestBody TestDto testDto) {
		return new ResponseEntity<>(testService.saveVisit(visitId, testDto), HttpStatus.CREATED);
	}

	// delete test
	@DeleteMapping("/testdetails/{testid}")
	public ResponseEntity<String> deleteTest(@PathVariable(name = "testid") int testId) {
		testService.deleteTest(testId);
		return new ResponseEntity<>("Test deleted Successfully", HttpStatus.ACCEPTED);
	}

	// update test
	@PutMapping("/testdetails/{testid}")
	public ResponseEntity<TestDto> updateTest(@RequestBody TestDto testDto, @PathVariable(name = "testid") int testId) {
		return new ResponseEntity<>(testService.updateTest(testDto, testId), HttpStatus.ACCEPTED);
	}

	// get all prescription details
	@GetMapping("/visitdetails/{visitId}/prescription")
	public ResponseEntity<List<PrescriptionDto>> getPrescriptionDetails(@PathVariable(name = "visitId") int visitId) {
		return new ResponseEntity<>(prescriptionService.getPrescriptionDetails(visitId), HttpStatus.OK);

	}

	// save prescription
	@PostMapping("/visitdetails/{visitId}/prescription")
	public ResponseEntity<PrescriptionDto> savePrescription(@PathVariable(name = "visitId") int visitId,
			@RequestBody PrescriptionDto prescriptionDto) {
		return new ResponseEntity<>(prescriptionService.saveVisit(visitId, prescriptionDto), HttpStatus.CREATED);
	}

	// delete prescription
	@DeleteMapping("/prescription/{prescriptionid}")
	public ResponseEntity<String> deletePrescription(@PathVariable(name = "prescriptionid") int prescriptionId) {
		prescriptionService.deletePrescription(prescriptionId);
		return new ResponseEntity<>("Prescription deleted Successfully", HttpStatus.ACCEPTED);
	}

	// update Prescription
	@PutMapping("/prescription/{prescriptionid}")
	public ResponseEntity<PrescriptionDto> updatePrescription(@RequestBody PrescriptionDto prescriptionDto,
			@PathVariable(name = "prescriptionid") int prescriptionId) {
		return new ResponseEntity<>(prescriptionService.updatePrescription(prescriptionDto, prescriptionId),
				HttpStatus.ACCEPTED);
	}

}

