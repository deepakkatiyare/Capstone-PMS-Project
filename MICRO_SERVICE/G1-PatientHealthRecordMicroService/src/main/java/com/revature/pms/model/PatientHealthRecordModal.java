package com.revature.pms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "visit_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PatientHealthRecordModal {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="visit_id")
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
	
	
	
}
