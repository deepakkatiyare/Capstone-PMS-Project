package com.revature.entity.dto;

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
	public PatientDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PatientDto(int patientId, String email, String title, String firstName, String lastName, String dob,
			String contactNumber, String password, String gender, String address) {
		super();
		this.patientId = patientId;
		this.email = email;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.contactNumber = contactNumber;
		this.password = password;
		this.gender = gender;
		this.address = address;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "PatientDto [patientId=" + patientId + ", email=" + email + ", title=" + title + ", firstName="
				+ firstName + ", lastName=" + lastName + ", dob=" + dob + ", contactNumber=" + contactNumber
				+ ", password=" + password + ", gender=" + gender + ", address=" + address + "]";
	}
	
}
