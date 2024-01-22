package com.delume.services;

import java.util.List;
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

	public Patient find(Long cpf) {
		Optional<Patient> obj = repo.findById(cpf);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found! Id: " + cpf));
	}

	public Patient insert(Patient obj) {
		obj.setCpf(null);
		return repo.save(obj);
	}

	public Patient update(Patient obj) {
		Patient newObj = find(obj.getCpf());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Long cpf) {
		find(cpf);
		try {
			repo.deleteById(cpf);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Cannot delete a category that has linker profiles.");
		}
	}
	
	public List<Patient> findAll() {
		return repo.findAll();
	}	
	
	public Patient fromDTO(PatientDTO objDto) {
		return new Patient(objDto.getCpf(), objDto.getName(), objDto.getEmail(), objDto.getPhone(), objDto.getAddress());
	}

	private void updateData(Patient newObj, Patient obj) {
		newObj.setName(obj.getName());
	}
}
