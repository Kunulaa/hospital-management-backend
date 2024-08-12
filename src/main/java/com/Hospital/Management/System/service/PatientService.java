package com.Hospital.Management.System.service;

import java.util.List;

import com.Hospital.Management.System.entity.Patient;

public interface PatientService {

	public Patient createPatient(Patient pnt);
	public List<Patient> createPatients(List<Patient> pnt);
	public Patient dltPatientById(Long id);
	public List<Patient> getAll();
}
