package com.revature.entity;

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
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name="allergy")
public class Allergy {
	@Column(name="allergy_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int allergyId;
	
	@Column(name="allergy_name")
	private String allergyName;
	
	@Column(name="allergy_notes")
	private String allergyNotes;
	

}
