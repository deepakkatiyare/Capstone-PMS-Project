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
@Table(name = "test_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TestsModal {
	
	@Id
	@Column(name="test_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int testId;
	private String testName;
	private String result;
	private String testNotes;
	
	
	
}
