package com.revature.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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

}
