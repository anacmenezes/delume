package com.delume.services;

import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.delume.domain.Employee;
import com.delume.dto.EmployeeDTO;
import com.delume.repositories.EmployeeRepository;
import com.delume.services.exception.DataIntegrityException;
import com.delume.services.exception.ObjectNotFoundException;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;

	public Employee find(Long cpf) {
		Optional<Employee> obj = repo.findById(cpf);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found! Id: " + cpf + ", Type: " + Category.class.getName()));
	}

	public Employee insert(Employee obj) {
		obj.setCpf(null);
		return repo.save(obj);
	}

	public Employee update(Employee obj) {
		Employee newObj = find(obj.getCpf());
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
	
	public List<Employee> findAll() {
		return repo.findAll();
	}	
	
	public Employee fromDTO(EmployeeDTO objDto) {
		return new Employee(objDto.getCpf(), objDto.getName(),  objDto.getPhone(), objDto.getEmail(), objDto.getPassword(), objDto.getAddress(), null);
	}

	private void updateData(Employee newObj, Employee obj) {
		newObj.setName(obj.getName());
	}
}
