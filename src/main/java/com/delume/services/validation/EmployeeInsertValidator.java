package com.delume.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.delume.domain.Employee;
import com.delume.dto.EmployeeNewDTO;
import com.delume.repositories.EmployeeRepository;
import com.delume.resources.exception.FieldMessage;

public class EmployeeInsertValidator implements ConstraintValidator<RegisterInsert, EmployeeNewDTO> {

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public void initialize(RegisterInsert ann) {
	}

	@Override
	public boolean isValid(EmployeeNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();

		Employee aux = repo.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Existing email"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}