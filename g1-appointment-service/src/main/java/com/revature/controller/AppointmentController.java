package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.AppointmentDto;
import com.revature.entity.Appointment;
import com.revature.service.AppointmentService;

@RestController
@EnableDiscoveryClient
@RequestMapping("api/v1")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	// get all appointments
	@GetMapping("/patient/{patientId}/appointments")
	public ResponseEntity<List<AppointmentDto>> getAllAppointments(@PathVariable(name = "patientId") int patientId) {
		return new ResponseEntity<>(appointmentService.getAllAppointments(patientId), HttpStatus.OK);
	}

	// save appointments
	@PostMapping("/appointment")
	public ResponseEntity<AppointmentDto> saveAppointment(@RequestBody AppointmentDto appointmentDto) {
		return new ResponseEntity<>(appointmentService.saveAppointment(appointmentDto), HttpStatus.CREATED);
	}

	// delete appointments
	@DeleteMapping("/appointment/{id}")
	public ResponseEntity<String> deleteAppointment(@PathVariable(name = "id") int id) {
		appointmentService.deleteAppointment(id);
		return new ResponseEntity<>("Appointment deleted Successfully", HttpStatus.ACCEPTED);
	}

	// update appointments
	@PutMapping("/appointment/{id}")
	public ResponseEntity<AppointmentDto> updateAppointment(@RequestBody Appointment appointment,
			@PathVariable(name = "id") int id) {
		return new ResponseEntity<>(appointmentService.updateAppointment(appointment, id), HttpStatus.ACCEPTED);
	}

	// get all pending appointments
	@GetMapping("/appointment/{email}/{acceptance}")
	public ResponseEntity<List<AppointmentDto>> getPendingAppointments(
			@PathVariable(name = "email") String physicianEmail
//			@PathVariable(name = "acceptance") String acceptance
	) {
		return new ResponseEntity<>(appointmentService.getPendingAppointments(physicianEmail, "pending"),
				HttpStatus.OK);
	}

	// get all accepted appointments for physician
	@GetMapping("/appointment/{email}/{date}/{acceptance}")
	public ResponseEntity<List<AppointmentDto>> getAcceptedAppointments(
			@PathVariable(name = "email") String physicianEmail, @PathVariable(name = "date") String date
//			@PathVariable(name = "acceptance") String acceptance
	) {
		return new ResponseEntity<>(appointmentService.getAcceptedAppointments(physicianEmail, date, "accepted"),
				HttpStatus.OK);
	}

	// get all accepted appointments for nurse
	@GetMapping("/appointment/{acceptance}")
	public ResponseEntity<List<AppointmentDto>> getOnlyAcceptedAppointments(
//			@PathVariable(name = "acceptance") String acceptance
	) {
		return new ResponseEntity<>(appointmentService.getOnlyAcceptedAppointments("accepted"), HttpStatus.OK);
	}

}
