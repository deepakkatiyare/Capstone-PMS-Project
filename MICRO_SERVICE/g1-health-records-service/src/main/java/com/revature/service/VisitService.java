package com.revature.service;

import java.util.List;

import com.revature.entity.VisitDetails;
import com.revature.payload.VisitDto;

public interface VisitService {

	public VisitDto saveVisit(int patientId, VisitDto visitDto);

	public List<VisitDto> getAllVisits(int patientId);

	public VisitDto updateVisit(VisitDto visitDto, int visitId);

	public void deleteVisit(int visitId);

}

