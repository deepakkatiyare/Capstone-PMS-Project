package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.entity.TestDetails;
import com.revature.entity.VisitDetails;
import com.revature.payload.TestDto;

public interface TestRepository extends JpaRepository<TestDetails, Integer> {

	List<TestDetails> findAllByVisitId(VisitDetails v);


}