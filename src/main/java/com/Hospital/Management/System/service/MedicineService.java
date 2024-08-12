package com.Hospital.Management.System.service;

import java.util.List;

import com.Hospital.Management.System.doclogin.dto.MedicineDto;
import com.Hospital.Management.System.doclogin.entity.Medicine;

public interface MedicineService {
	public Medicine createMedicine(Medicine med);
	public List<Medicine> createMedicines(List<Medicine>meds);
	public Medicine updateMedicineById(Long id, Medicine med);
	public String deleteMedicineById(Long id );
	public Medicine getById(Long id);
	public List<Medicine> getAll();
	public Medicine withdrawStock(Long id, MedicineDto request);
	
}
