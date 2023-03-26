package com.revature.pms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PHYSICIAN_AVAILABILITY")
public class PhysicianAvailability {
	@Id
	@Column(name = "PHYSICIAN_EMAIL")
	private String email;
	
	@Column(name = "PHYSICIAN_NAME")
	private String physicianName;
	
	@Column(name = "PHYSICIAN_AVAILABLE_FROM")
	private String startDate;
	
	@Column(name = "PHYSICIAN_AVAILABLE_TILL")
	private String endDate;
	
	@Column(name = "IS_AVAILABLE")
	private boolean isAvailable;
	
	 	
}
