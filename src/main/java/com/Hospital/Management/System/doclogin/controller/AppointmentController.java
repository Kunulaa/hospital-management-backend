package com.Hospital.Management.System.doclogin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hospital.Management.System.doclogin.entity.Appointment;
import com.Hospital.Management.System.doclogin.entity.Medicine;
import com.Hospital.Management.System.service.AppointmentService;

@RestController
@RequestMapping("/api/v3")
public class AppointmentController {
	@Autowired
	private AppointmentService aps;
	
	@PostMapping("/single")
	public ResponseEntity<Appointment> createMed(@RequestBody Appointment appn){
		Appointment m=aps.createApponint(appn);
		return ResponseEntity.ok(m);
	}
	@PostMapping("/all")
	public ResponseEntity<List<Appointment>> createapn(@RequestBody List<Appointment> app){
		List<Appointment> mcn=aps.createAppoint(app);
		return ResponseEntity.ok(mcn);
	}
	
	@PutMapping("/{id}/rk")
	public ResponseEntity<Appointment> updateappn(@PathVariable Long id, @RequestBody Appointment ap){
		Appointment mc=aps.updateAppointById(id, ap);
		return ResponseEntity.ok(mc);
	}
	@DeleteMapping("/{id}/dlt")
	public ResponseEntity<String> dltMed(@PathVariable Long id){
		aps.deleteAppoinById(id);
		return ResponseEntity.ok("Id deleted successfully....");
	}
	@GetMapping("/{id}/get")
	public ResponseEntity<Appointment> getapn(@PathVariable Long id){
		Appointment m=aps.getById(id);
		return ResponseEntity.ok(m);
	}
	@GetMapping("/getall")
	public ResponseEntity<List<Appointment>> getAll(){
		List<Appointment> m=aps.getAll();
		return ResponseEntity.ok(m);
	}
	
	
	
}
