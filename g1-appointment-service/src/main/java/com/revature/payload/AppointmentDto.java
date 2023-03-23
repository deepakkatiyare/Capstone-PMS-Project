package com.revature.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentDto {

	private int id ;
	private String reason;
	private String date;
	private String acceptance;
	private int patientId;
	private String physcianEmail;
	private String submissionDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAcceptance() {
		return acceptance;
	}
	public void setAcceptance(String acceptance) {
		this.acceptance = acceptance;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPhyscianEmail() {
		return physcianEmail;
	}
	public void setPhyscianEmail(String physcianEmail) {
		this.physcianEmail = physcianEmail;
	}
	public String getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(String submissionDate) {
		this.submissionDate = submissionDate;
	}
	
	
}
