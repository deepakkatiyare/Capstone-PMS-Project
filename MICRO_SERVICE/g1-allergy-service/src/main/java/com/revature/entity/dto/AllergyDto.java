package com.revature.entity.dto;

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

public class AllergyDto {
	private int allergyId;
	private String allergyName;
	private String allergyNotes;
	
}
