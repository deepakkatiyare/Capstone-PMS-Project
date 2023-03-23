package com.revature.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentDto {

	private int id;
	private String reason;
	private String date;
	private String acceptance;
	private int patientId;
	private String physicianEmail;
	private String submissionDate;
	
	
}