package com.revature.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.Model.BasicPatientInfo;


public interface PatientRepository extends JpaRepository<BasicPatientInfo, Integer>{
	
	
}
