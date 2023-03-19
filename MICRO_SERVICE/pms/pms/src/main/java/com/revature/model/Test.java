package com.revature.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Test {
	@Id
	private int testId;
	private String testName;
	private String result;
	private String testNotes;
	private int visitId;
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getTestNotes() {
		return testNotes;
	}
	public void setTestNotes(String testNotes) {
		this.testNotes = testNotes;
	}
	public int getVisitId() {
		return visitId;
	}
	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}
}
