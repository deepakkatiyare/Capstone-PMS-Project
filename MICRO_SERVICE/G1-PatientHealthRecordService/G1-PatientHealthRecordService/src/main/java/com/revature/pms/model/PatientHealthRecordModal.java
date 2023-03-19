package com.revature.pms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "visit_details")
public class PatientHealthRecordModal {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="visit_id")
	private int visitId;
	@Column(name = "patient_id")
	private int patientId;
	@Column(name="height")
	private float height;
	@Column(name="weight")
	private float weight;
	@Column(name="blood_pressure_systolic")
	private int bloodPressureSystolic;
	@Column(name="blood_pressure_diastolic")
	private int bloodPressureDiastolic;
	@Column(name="body_temperature")
	private float bodyTemperature;
	
	@Column(name="respiration_rate")
	private int respirationRate;
	@Column(name="blood_group")
	private String bloodGroup;
	@Column(name="nurse_email")
	private String nurseEmail;
	@Column(name="physician_email")
	private String physicianEmail;
	@Column(name="appointment_id")
	private int appointmentId;
	@Column(name="key_notes")
	private String keyNotes;
	@Column(name="allergy_id")
	private int allergyId;
	
	
	public PatientHealthRecordModal(int visitId, int patientId, float height, float weight, int bloodPressureSystolic,
			int bloodPressureDiastolic, float bodyTemperature, int respirationRate, String bloodGroup,
			String nurseEmail, String physicianEmail, int appointmentId, String keyNotes, int allergyId) {
		super();
		this.visitId = visitId;
		this.patientId = patientId;
		this.height = height;
		this.weight = weight;
		this.bloodPressureSystolic = bloodPressureSystolic;
		this.bloodPressureDiastolic = bloodPressureDiastolic;
		this.bodyTemperature = bodyTemperature;
		this.respirationRate = respirationRate;
		this.bloodGroup = bloodGroup;
		this.nurseEmail = nurseEmail;
		this.physicianEmail = physicianEmail;
		this.appointmentId = appointmentId;
		this.keyNotes = keyNotes;
		this.allergyId = allergyId;
	}

	
	
	public PatientHealthRecordModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getVisitId() {
		return visitId;
	}
	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public int getBloodPressureSystolic() {
		return bloodPressureSystolic;
	}
	public void setBloodPressureSystolic(int bloodPressureSystolic) {
		this.bloodPressureSystolic = bloodPressureSystolic;
	}
	public int getBloodPressureDiastolic() {
		return bloodPressureDiastolic;
	}
	public void setBloodPressureDiastolic(int bloodPressureDiastolic) {
		this.bloodPressureDiastolic = bloodPressureDiastolic;
	}
	public float getBodyTemperature() {
		return bodyTemperature;
	}
	public void setBodyTemperature(float bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
	}
	public int getRespirationRate() {
		return respirationRate;
	}
	public void setRespirationRate(int respirationRate) {
		this.respirationRate = respirationRate;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getNurseEmail() {
		return nurseEmail;
	}
	public void setNurseEmail(String nurseEmail) {
		this.nurseEmail = nurseEmail;
	}
	public String getPhysicianEmail() {
		return physicianEmail;
	}
	public void setPhysicianEmail(String physicianEmail) {
		this.physicianEmail = physicianEmail;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getKeyNotes() {
		return keyNotes;
	}
	public void setKeyNotes(String keyNotes) {
		this.keyNotes = keyNotes;
	}
	public int getAllergyId() {
		return allergyId;
	}
	public void setAllergyId(int allergyId) {
		this.allergyId = allergyId;
	}
	
	
	@Override
	public String toString() {
		return "PatientHealthRecordModal [visitId=" + visitId + ", patientId=" + patientId + ", height=" + height
				+ ", weight=" + weight + ", bloodPressureSystolic=" + bloodPressureSystolic
				+ ", bloodPressureDiastolic=" + bloodPressureDiastolic + ", bodyTemperature=" + bodyTemperature
				+ ", respirationRate=" + respirationRate + ", bloodGroup=" + bloodGroup + ", nurseEmail=" + nurseEmail
				+ ", physicianEmail=" + physicianEmail + ", appointmentId=" + appointmentId + ", keyNotes=" + keyNotes
				+ ", allergyId=" + allergyId + "]";
	}
	
	
	
}
