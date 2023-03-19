package com.revature.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Physician {
	@Id
	private String physicianEmail;
	private String date;
	private String availability;
	public String getPhysicianEmail() {
		return physicianEmail;
	}
	public void setPhysicianEmail(String physicianEmail) {
		this.physicianEmail = physicianEmail;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
}
