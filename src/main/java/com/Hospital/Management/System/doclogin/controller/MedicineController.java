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

import com.Hospital.Management.System.doclogin.dto.MedicineDto;
import com.Hospital.Management.System.doclogin.entity.Medicine;
import com.Hospital.Management.System.service.MedicineService;

@RestController
@RequestMapping("/medicines")
public class MedicineController {
	@Autowired
	private MedicineService med;
	
	@PostMapping("/single")
	public ResponseEntity<Medicine> createMed(@RequestBody Medicine med1){
		Medicine m=med.createMedicine(med1);
		return ResponseEntity.ok(m);
	}
	@PostMapping("/all")
	public ResponseEntity<List<Medicine>> createMeds(@RequestBody List<Medicine> med1){
		List<Medicine> mcn=med.createMedicines(med1);
		return ResponseEntity.ok(mcn);
	}
	
	@PutMapping("/{id}/rk")
	public ResponseEntity<Medicine> updateMed(@PathVariable Long id, @RequestBody Medicine md){
		Medicine mc=med.updateMedicineById(id, md);
		return ResponseEntity.ok(mc);
	}
	@DeleteMapping("/{id}/dlt")
	public ResponseEntity<String> dltMed(@PathVariable Long id){
		med.deleteMedicineById(id);
		return ResponseEntity.ok("Id deleted successfully....");
	}
	@GetMapping("/{id}/get")
	public ResponseEntity<Medicine> getMed(@PathVariable Long id){
		Medicine m=med.getById(id);
		return ResponseEntity.ok(m);
	}
	@GetMapping("/getall")
	public ResponseEntity<List<Medicine>> getAll(){
		List<Medicine> m=med.getAll();
		return ResponseEntity.ok(m);
	}
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<Medicine> withdrawstock(@PathVariable Long id, @RequestBody MedicineDto dto){
		Medicine mn=med.withdrawStock(id, dto);
		return ResponseEntity.ok(mn);
	}
	
	
	
}
