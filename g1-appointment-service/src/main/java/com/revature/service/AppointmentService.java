package com.revature.service;

import java.util.List;

import com.revature.dto.AppointmentDto;
import com.revature.entity.Appointment;

public interface AppointmentService {

	public AppointmentDto saveAppointment(AppointmentDto appointmentDto);

	public List<AppointmentDto> getAllAppointments(int patientId);

	public void deleteAppointment(int id);

	public AppointmentDto updateAppointment(Appointment appointmentDto, int id);

	public List<AppointmentDto> getPendingAppointments(String physicianEmail, String acceptance);

	public List<AppointmentDto> getAcceptedAppointments(String physicianEmail, String acceptance, String date);

	public List<AppointmentDto> getOnlyAcceptedAppointments(String acceptance);
}
