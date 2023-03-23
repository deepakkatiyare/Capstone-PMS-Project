package com.revature.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhysicianAvailabilityDto {
	
	private String physicianEmail;
	private String date;
	private String availability;
}
