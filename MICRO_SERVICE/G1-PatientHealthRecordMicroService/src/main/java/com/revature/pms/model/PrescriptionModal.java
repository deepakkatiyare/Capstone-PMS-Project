package com.revature.pms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prescription_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionModal {
	@Id
	@Column(name="p_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int prescriptionId;
	private String prescriptionName;
	private String dosage;
	private String prescriptionNotes;
	

}
