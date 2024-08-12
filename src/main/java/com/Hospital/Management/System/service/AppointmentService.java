package com.Hospital.Management.System.service;

import java.util.List;

import com.Hospital.Management.System.doclogin.entity.Appointment;

public interface AppointmentService {
	public Appointment createApponint(Appointment app);
	public List<Appointment> createAppoint(List<Appointment>apa);
	public Appointment updateAppointById(Long id, Appointment ap);
	public String deleteAppoinById(Long id );
	public Appointment getById(Long id);
	public List<Appointment> getAll();

}
