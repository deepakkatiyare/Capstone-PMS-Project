package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.entity.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment , Integer> {
	
	List<Appointment> findAllByPatientId(int patientId);

	List<Appointment> findAllByPhysicianEmailAndAcceptance(String physicianEmail, String acceptance);

	List<Appointment> findAllByPhysicianEmailAndDateAndAcceptance(String physicianEmail, String date, String acceptance);

	List<Appointment> findAllByAcceptance(String acceptance);
	
}
