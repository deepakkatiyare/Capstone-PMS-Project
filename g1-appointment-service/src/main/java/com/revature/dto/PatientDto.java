package com.revature.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

	private int patientId;
	private String email;
	private String title;
	private String firstName;
	private String lastName;
	private String dob;
	private String contactNumber;
	private String password;
	private String gender;
	private String address;

}