package com.revature.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientDto {
	private long patientId;
	private String email;
	private String title;
	private String firstName;
	private String lastName;
	private String dob;
	private String mobileNo;
	private String password;
	private String gender;
	private String address;
}
