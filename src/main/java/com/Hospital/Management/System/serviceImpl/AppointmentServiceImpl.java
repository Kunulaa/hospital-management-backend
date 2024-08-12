package com.Hospital.Management.System.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hospital.Management.System.Exception.ResourceNotFoundException;
import com.Hospital.Management.System.doclogin.entity.Appointment;
import com.Hospital.Management.System.doclogin.entity.Medicine;
import com.Hospital.Management.System.doclogin.repository.AppointmentsRepository;
import com.Hospital.Management.System.service.AppointmentService;
@Service
public class AppointmentServiceImpl implements AppointmentService {
	@Autowired
	private AppointmentsRepository apprepo;

	@Override
	public Appointment createApponint(Appointment app) {
		return apprepo.save(app);
	}

	@Override
	public List<Appointment> createAppoint(List<Appointment> apa) {
		return apprepo.saveAll(apa);
	}

	@Override
	public Appointment updateAppointById(Long id, Appointment ap) {
		Appointment existingAppoin = apprepo.findById(id).orElseThrow(()-> new RuntimeException("no medicine is present"));
		existingAppoin.setName(ap.getName());
		existingAppoin.setAge(ap.getAge());
		existingAppoin.setNumber(ap.getNumber());
		existingAppoin.setSymtomps(ap.getSymtomps());
		return apprepo.save(existingAppoin);
	}

	@Override
	public String deleteAppoinById(Long id) {
		apprepo.deleteById(id);
		return "deleted..";
	}

	@Override
	public Appointment getById(Long id) {
		return apprepo.getById(id);
	}

	@Override
	public List<Appointment> getAll() {
		return apprepo.findAll();
	}
	

}
