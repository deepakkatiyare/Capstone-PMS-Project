package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.AppointmentInterface;
import com.revature.model.Appointment;


@Service
public class AppointmentService {
	@Autowired
	private AppointmentInterface apponitment;
	
	Appointment appo=new Appointment();
	
	public Appointment getAppointment(Appointment appointment){
		return apponitment.save(appointment);
		
	}
	public List<Appointment> getAppointments(String physcianEmail,String date,String accptence){
		return apponitment.findBystatusanddate(physcianEmail,date,accptence);
		
	}
	
	public List<Appointment> getAppointments(String accptence){
		return apponitment.findBystatus(accptence);
		
	}
	
	public List<Appointment> getPatientsAppointments(Integer id){
		return apponitment.findByPatient_ID(id);
		
	}
	
	
	public Appointment updateStatus(Appointment appointment){
		return apponitment.save(appointment);
		
	}
	
	public void deleteByid(Integer id) {
		apponitment.deleteById(id);
	}
	}
