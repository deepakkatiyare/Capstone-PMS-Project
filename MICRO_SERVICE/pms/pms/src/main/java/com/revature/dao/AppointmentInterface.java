package com.revature.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.model.Appointment;
import com.revature.model.PatientDetails;

public interface AppointmentInterface extends JpaRepository<Appointment, Integer>{

	@Query( value="Select * FROM Appointment  WHERE physcian_email=?1 AND date=?2 AND acceptance=?3" ,nativeQuery = true)
	List<Appointment> findBystatusanddate(@PathVariable("physcianEmail") String physcianEmail,@PathVariable("date") String date,@PathVariable("acceptance") String acceptance);
	
	
	@Query( value="Select * FROM Appointment  WHERE acceptance=?1" ,nativeQuery = true)
	List<Appointment> findBystatus(@PathVariable("status") String status);
//	List<PatientDetails> findBystatusAndDob( String status,String DoB);

	
	@Query(value="select * from Appointment where patient_id=?1",nativeQuery = true)
	List<Appointment> findByPatient_ID(@PathVariable("patient_id") Integer id);
	
	@Modifying
	@Query( value="update Appointment set acceptance=?2 WHERE id=?1" ,nativeQuery = true)
	List<Appointment> updatebyid(@PathVariable Integer id,@RequestParam("acceptance") String status);
	
	public Integer deleteById(int id);
}
