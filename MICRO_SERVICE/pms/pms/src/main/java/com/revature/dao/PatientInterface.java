package com.revature.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.revature.model.Patient;

public interface PatientInterface extends JpaRepository<Patient, Integer>{
//	@Query( value="Select * FROM Patient  WHERE patientId=?1 AND date=?2",nativeQuery = true)
//	List<Patient> findBystatusanddate(@PathVariable("acceptance") String acceptance,@PathVariable("date") String date);
	
	
//	@Query( value="Select * FROM Patient  WHERE patientId=?1" ,nativeQuery = true)
//	List<Patient> findBystatus(@PathVariable("patientId") int id);
//	List<PatientDetails> findBystatusAndDob( String status,String DoB);

	
	@Query( value="Select * from Patient where patientId=?1",nativeQuery = true)
	List<Patient> findByPatient_ID(Integer id);
}
