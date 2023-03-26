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
@Table(name = "Test_details")
public class TestDetails {

	@Id
	@Column(name = "test_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int testId;

	@Column(name = "test_name")
	private String testName;

	@Column(name = "result")
	private String result;

	@Column(name = "test_notes")
	private String testNotes;

	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "visit_id")
	private VisitDetails visitId;
}

