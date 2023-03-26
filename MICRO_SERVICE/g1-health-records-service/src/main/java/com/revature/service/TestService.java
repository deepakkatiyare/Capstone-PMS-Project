package com.revature.service;

import java.util.List;

import com.revature.entity.TestDetails;
import com.revature.payload.TestDto;

public interface TestService {

	public TestDto saveVisit(int visitId, TestDto testDto);

	public List<TestDto> getTestDetails(int visitId);

	public TestDto updateTest(TestDto testDto, int testId);

	public void deleteTest(int testId);
}
