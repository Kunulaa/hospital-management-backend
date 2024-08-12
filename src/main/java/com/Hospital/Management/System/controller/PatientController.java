package com.Hospital.Management.System.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hospital.Management.System.entity.Patient;
import com.Hospital.Management.System.service.PatientService;
@RestController
@RequestMapping("/patient/v1")
public class PatientController {
	
	private PatientService ptser;

	public PatientController(PatientService ptser) {
		super();
		this.ptser = ptser;
	}
	@PostMapping("/one")
	public ResponseEntity<Patient> saveP(@RequestBody Patient pt) {
		Patient pt1=ptser.createPatient(pt);
		return ResponseEntity.ok(pt1);
	}
	
	@PostMapping("/all")
	public ResponseEntity<String> savePt(@RequestBody List<Patient> pt) {
		List<Patient> pt1=ptser.createPatients(pt);
		return ResponseEntity.ok("Patients registered successfully");
	}
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<Patient> dlt(@PathVariable Long id){
		Patient pt2=ptser.dltPatientById(id);
		return ResponseEntity.ok(pt2);
	}
	@GetMapping("/allp")
	public ResponseEntity<List<Patient>> getall(){
		List<Patient> pt2=ptser.getAll();
		return ResponseEntity.ok(pt2);
	}
	

}
