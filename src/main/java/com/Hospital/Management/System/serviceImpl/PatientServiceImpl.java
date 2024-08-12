package com.Hospital.Management.System.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Hospital.Management.System.entity.Patient;
import com.Hospital.Management.System.repository.PatientRepository;
import com.Hospital.Management.System.service.PatientService;
@Service
public class PatientServiceImpl implements PatientService{
	private PatientRepository patientRepository;

	public PatientServiceImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}

	@Override
	public Patient createPatient(Patient pnt) {
		Patient pt=patientRepository.save(pnt);
		return pt;
	}

	@Override
	public List<Patient> createPatients(List<Patient> pnt) {
		List<Patient> pn=patientRepository.saveAll(pnt);
		return pn;
	}

	@Override
	public Patient dltPatientById(Long id) {
		Patient pnn=patientRepository.findById(id).orElseThrow(()-> new RuntimeException("patient not found"));
		if(pnn!=null) {
			patientRepository.deleteById(id);
			
		}
		return pnn;
		
		
	}

	@Override
	public List<Patient> getAll() {
		return patientRepository.findAll();
	}

	

}
