package com.delume.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.delume.domain.Appointment;
import com.delume.dto.AppointmentDTO;
import com.delume.repositories.AppointmentRepository;
import com.delume.services.exception.DataIntegrityException;
import com.delume.services.exception.ObjectNotFoundException;

@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentRepository repo;

	public Appointment find(Integer id) {
		Optional<Appointment> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id));
	}
	
	public Appointment insert(Appointment obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Appointment update(Appointment obj) {
		Appointment newObj = find(obj.getId());
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
	
	public List<Appointment> findAll() {
		return repo.findAll();
	}	
	
	public Appointment fromDTO(AppointmentDTO objDto) {
		return new Appointment(objDto.getId(), objDto.getDate(),  objDto.getInformations(), null, null, null);
	}

	private void updateData(Appointment newObj, Appointment obj) {
		newObj.setId(obj.getId());
	}
}
