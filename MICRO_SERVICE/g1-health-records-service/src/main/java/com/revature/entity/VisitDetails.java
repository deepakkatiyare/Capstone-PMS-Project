package com.revature.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "visit_details", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "nurse_email", "physician_email" }) })
public class VisitDetails {

	@Id
	@Column(name = "visit_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int visitId;

	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id")
	private Patient patientId;

	@Column(name = "height")
	private float height;

	@Column(name = "weight")
	private float weight;

	@Column(name = "blood_pressure_systolic")
	private int bpSystolic;

	@Column(name = "blood_pressure_diastolic")
	private int bpDiastolic;

	@Column(name = "body_temparature")
	private float bodyTemparature;

	@Column(name = "respiration_rate")
	private int respirationRate;

	@Column(name = "blood_group")
	private String bloodGroup;

	@Column(name = "nurse_email", nullable = false)
	private String nurseEmail;

	@Column(name = "physician_email", nullable = false)
	private String physicianEmail;

//	@OneToOne
//	@JoinColumn(name = "appointment_id")
	@Column(name = "appointment_id")
	private int appointmentId;

	@Column(name = "key_notes")
	private String keyNotes;

	@Column(name = "allergy_id")
	private int allergyId;

}
