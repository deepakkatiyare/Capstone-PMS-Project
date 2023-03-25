package com.revature.pms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.pms.model.TestsModal;
import com.revature.pms.repo.TestsRepository;

@Service
public class TestService {
	
	@Autowired
	private TestsRepository testRepository;
	
	public TestsModal getTestById(int id) {
		return testRepository.findById(id).orElse(null);
	}
	public TestsModal addTestDetails(TestsModal testDetails) {

		return testRepository.save(testDetails);
	}

}
