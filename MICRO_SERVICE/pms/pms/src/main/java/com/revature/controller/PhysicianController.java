package com.revature.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dao.AppointmentInterface;
import com.revature.dao.DataBaseConnectionInterface;
import com.revature.dao.PatientInterface;
import com.revature.dto.AppoinmentDto;
import com.revature.model.Appointment;
import com.revature.model.Patient;
import com.revature.model.PatientDetails;
import com.revature.service.AppointmentService;


@RestController
@CrossOrigin(origins = "*")
public class PhysicianController {
	
	Appointment appoint = new Appointment();
	AppoinmentDto appointmetdto=new AppoinmentDto();
	
	@Autowired
	AppointmentService appointmentservice;
	

	
	@Autowired
	private AppointmentInterface appoinmentinterface;
	
	
	
	@GetMapping("/patient/{id}/appointment")
	public List<Appointment> patientAppointments(@PathVariable Integer id){
		return appointmentservice.getPatientsAppointments(id);
		
	}
	
	
	@PostMapping("/appointment")
	public Appointment appointments(@RequestBody Appointment appointments){
		return appointmentservice.getAppointment(appointments);
	}
	
	@GetMapping("/appointments/{physcianEmail}/{date}/{acceptance}")
	public List<Appointment>patientsByStatus(@PathVariable String physcianEmail,@PathVariable String date,@PathVariable String acceptance){
		return appointmentservice.getAppointments(physcianEmail,date,acceptance);		
	}

	
	@GetMapping("/appointment/{status}")
	public List<Appointment> patientsByStatus(@PathVariable String status){
	
		return appointmentservice.getAppointments(status);		
	}
	@PutMapping("/appointment")
	public Appointment updateAppointment(@RequestBody Appointment appointment) {
		return appointmentservice.updateStatus(appointment);
	}
	
	@DeleteMapping("/appointment/{id}")
	public void deletebyid(@PathVariable Integer id){
		appointmentservice.deleteByid(id);
	}

	

}
