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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prescription_details")
public class Prescription {

	@Id
	@Column(name = "prescription_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prescriptionId;

	@Column(name = "prescription_name")
	private String prescriptionName;

	@Column(name = "dosage")
	private String dosage;

	@Column(name = "prescription_notes")
	private String prescriptionNotes;

	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "visit_id")
	private VisitDetails visitId;
}
