package com.revature.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
	
	private String email;
	private String title;
	private String firstName;
	private String lastName;
	private String dob;
	private String contact;
	private String password;
	private String gender;
	private String address;
	
}
