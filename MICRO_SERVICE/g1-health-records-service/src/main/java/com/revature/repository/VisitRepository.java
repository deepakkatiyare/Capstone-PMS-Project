package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.entity.Patient;
import com.revature.entity.VisitDetails;
import com.revature.payload.VisitDto;

public interface VisitRepository extends JpaRepository<VisitDetails, Integer> {

	List<VisitDetails> findAllByPatientId(Patient p);


}