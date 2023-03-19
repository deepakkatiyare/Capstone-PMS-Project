package com.revature.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class VisitDetails {
	
	@Id
	private int visitId;
	private int patientId;
	private float height;
	private float weight;
	private int bloodPressureSystolic;
	private int bloodPressureDiastolic;
	private float bodyTemperature;
	private int respirationRate;
	private String bloodGroup;
	private String nurseEmail;
	private String physicianEmail;
	private int appointmentId;
	private String keyNotes;
	private int allergyId;
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
}
