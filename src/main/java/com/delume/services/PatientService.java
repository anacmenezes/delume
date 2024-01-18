package com.delume.services;

import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.delume.domain.Patient;
import com.delume.dto.PatientDTO;
import com.delume.repositories.PatientRepository;
import com.delume.services.exception.DataIntegrityException;
import com.delume.services.exception.ObjectNotFoundException;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository repo;

	public Patient find(Integer id) {
		Optional<Patient> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + Category.class.getName()));
	}

	public Patient insert(Patient obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Patient update(Patient obj) {
		Patient newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Cannot delete a category that has linker profiles.");
		}
	}
	
	public List<Patient> findAll() {
		return repo.findAll();
	}	
	
	public Patient fromDTO(PatientDTO objDto) {
		return new Patient(objDto.getId(), objDto.getCpf(), objDto.getName(), objDto.getEmail(), objDto.getPhone());
	}

	private void updateData(Patient newObj, Patient obj) {
		newObj.setName(obj.getName());
	}
}
