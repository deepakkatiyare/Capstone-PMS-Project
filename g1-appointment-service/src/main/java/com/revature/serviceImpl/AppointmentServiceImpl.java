package com.revature.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dto.AppointmentDto;
import com.revature.entity.Appointment;
import com.revature.repository.AppointmentRepo;
import com.revature.service.AppointmentService;



@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	private AppointmentRepo appointmentRepo;
	
	@Autowired
	public ModelMapper modelMapper;

	@Override
	public List<AppointmentDto> getAllAppointments(int patientId) {
		List<Appointment> appointments = appointmentRepo.findAllByPatientId(patientId);
		return appointments.stream().map(
				appointment -> modelMapper.map(appointment, AppointmentDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public AppointmentDto saveAppointment(AppointmentDto appointmentDto) {
		Appointment appointment = modelMapper.map(appointmentDto, Appointment.class);
		Appointment savedAppointments = appointmentRepo.save(appointment);
		return modelMapper.map(savedAppointments, AppointmentDto.class);
	}

	@Override
	public void deleteAppointment(int id) {
		appointmentRepo.deleteById(id);
	}

	@Override
	public AppointmentDto updateAppointment(Appointment appointmentDto, int id) {
		Appointment a = appointmentRepo.findById(id).get();
		a.setAcceptance(appointmentDto.getAcceptance());
		a.setDate(appointmentDto.getDate());
		a.setPhysicianEmail(appointmentDto.getPhysicianEmail());
		appointmentRepo.save(a);
		return modelMapper.map(appointmentRepo.saveAndFlush(appointmentDto) ,AppointmentDto.class);
	}

	@Override
	public List<AppointmentDto> getPendingAppointments(String physicianEmail, String acceptance) {
		List<Appointment> appointments = appointmentRepo.findAllByPhysicianEmailAndAcceptance(physicianEmail, acceptance);
		return appointments.stream().map(
				appointment -> modelMapper.map(appointment, AppointmentDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<AppointmentDto> getAcceptedAppointments(String physicianEmail, String date, String acceptance) {
		List<Appointment> appointments = appointmentRepo.findAllByPhysicianEmailAndDateAndAcceptance(physicianEmail, date, acceptance);
		return appointments.stream().map(
				appointment -> modelMapper.map(appointment, AppointmentDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<AppointmentDto> getOnlyAcceptedAppointments(String acceptance) {
		List<Appointment> appointments = appointmentRepo.findAllByAcceptance(acceptance);
		return appointments.stream().map(appointment -> modelMapper.map(
				appointment, AppointmentDto.class))
				.collect(Collectors.toList());
	}

}
