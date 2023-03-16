package com.revature.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PatientInfo")
public class BasicPatientInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patientId;
	@Column
	private String patientFirstName;
	@Column
	private String patientLastName;
	@Column
	private String gender;
	@Column
	private String email;
	public BasicPatientInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BasicPatientInfo(int patientId, String patientFirstName, String patientLastName, String gender,
			String email) {
		super();
		this.patientId = patientId;
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		this.gender = gender;
		this.email = email;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientFirstName() {
		return patientFirstName;
	}
	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}
	public String getPatientLastName() {
		return patientLastName;
	}
	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "BasicPatientInfo [patientId=" + patientId + ", patientFirstName=" + patientFirstName
				+ ", patientLastName=" + patientLastName + ", gender=" + gender + ", email=" + email + "]";
	}
	
	

}
