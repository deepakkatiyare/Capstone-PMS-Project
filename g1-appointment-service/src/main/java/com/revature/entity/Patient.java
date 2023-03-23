package com.revature.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Patient")
public class Patient {
	@Column(name = "Patient_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patientId;
	
	@Column(name = "Email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "Title")
	private String title;
	
	@Column(name = "First_Name")
	private String firstName;
	
	@Column(name = "Last_Name")
	private String lastName;
	
	@Column(name = "DOB")
	private String dob;
	
	@Column(name = "Contact_Number")
	private String contactNumber;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Gender")
	private String gender;
	
	@Column(name = "Address")
	private String address;
}
