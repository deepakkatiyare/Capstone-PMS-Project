package com.revature.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.model.PatientDetails;

public interface DataBaseConnectionInterface extends JpaRepository <PatientDetails , Integer>{

//	@Query("from PatientDetails where status=status AND DoB=DoB")
	@Query( value="Select * FROM patient_details  WHERE status=?1 AND DoB=?2",nativeQuery = true)
	List<PatientDetails> findBystatusanddob(@PathVariable("status") String status,@PathVariable("DoB") String DoB);
	
	
	@Query( value="Select * FROM patient_details  WHERE status=?1" ,nativeQuery = true)
	List<PatientDetails> findBystatus(@PathVariable("status") String status);
//	List<PatientDetails> findBystatusAndDob( String status,String DoB);

	
	@Query("from PatientDetails where Patient_ID=?1")
	List<PatientDetails> findByPatient_ID(Integer id);
	
	
//	List<PatientDetails>findBystatusAndDoB(String status,String DoB);
}
