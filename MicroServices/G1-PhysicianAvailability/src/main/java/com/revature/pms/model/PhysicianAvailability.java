package com.revature.pms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Entity
@Table(name = "PHYSICIAN_AVAILABILITY")
public class PhysicianAvailability {
	
	@Id
	@Column(name = "PHYSICIAN_EMAIL")
	private String email;
	
	@Column(name = "AVAILABLE_DATE")
	private String date;
	
	@Column(name = "IS_AVAILABLE")
	private boolean isAvailable;
	
	public PhysicianAvailability() {
		super();
	}

	public PhysicianAvailability(String email, String date, boolean isAvailable) {
		super();
		this.email = email;
		this.date = date;
		this.isAvailable = isAvailable;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "PhysicianAvailability [email=" + email + ", date=" + date + ", isAvailable=" + isAvailable + "]";
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isAvailable() {
		return isAvailable;
	}
	
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	} 	
}
