package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.revature.entity.Patient;
import com.revature.entity.dto.PatientDto;

public interface PatientRepository extends JpaRepository<Patient,Integer>{
	public Patient findByEmailAndPassword(String email,String password);
}
