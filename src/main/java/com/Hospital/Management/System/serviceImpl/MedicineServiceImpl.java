package com.Hospital.Management.System.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.Hospital.Management.System.Exception.ResourceNotFoundException;
import com.Hospital.Management.System.doclogin.dto.MedicineDto;
import com.Hospital.Management.System.doclogin.entity.Medicine;
import com.Hospital.Management.System.doclogin.repository.MedicineRepository;
import com.Hospital.Management.System.service.MedicineService;
@Service
public class MedicineServiceImpl implements MedicineService{
	
	@Autowired
	private MedicineRepository repo;

	@Override
	public Medicine createMedicine(Medicine med) {
		return repo.save(med);
	}

	@Override
	public List<Medicine> createMedicines(List<Medicine> meds) {
		return repo.saveAll(meds);
	}

	

	@Override
	public String deleteMedicineById(Long id) {
			Medicine med=repo.findById(id).orElseThrow(()-> new RuntimeException("id doesn't exist"));
			if(med!=null) {
				repo.delete(med);
			}
			return "id deleted successfully";
	}

	@Override
	public Medicine getById(Long id) {
		return repo.getById(id);
	}

	@Override
	public List<Medicine> getAll() {
		return repo.findAll();
	}

	@Override
	public Medicine updateMedicineById(Long id, Medicine med) {
		 Optional<Medicine> optionalMedicine = repo.findById(id);
	        if (optionalMedicine.isPresent()) {
	           Medicine medget=optionalMedicine.get();
	           medget.setDrugName(med.getDrugName());
	           medget.setStock(med.getStock());
	           return repo.save(medget);
	           
	        } else {
	            throw new ResourceNotFoundException("Medicine not found with this id");
	        }
	}


	@Override
	public Medicine withdrawStock(Long id, MedicineDto request) {
		Medicine med= repo.findById(id).orElseThrow(()-> new RuntimeException("this doesn't exist"));
		long stc=med.getStock();
		if(stc>request.getStock()) {
			long updatedStock=stc-request.getStock();
			med.setStock(updatedStock);
			repo.save(med);
		}
		else {
			throw new RuntimeException("Don't have enough stock..");
		}
		return med;
	}
	

	
}
