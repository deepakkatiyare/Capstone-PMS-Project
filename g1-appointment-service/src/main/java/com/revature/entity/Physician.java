package com.revature.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "physician")
public class Physician {

	@Column(name = "Physician_email")
	@Id
	private String physicianEmail;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "availability")
	private String availability;
}
