package com.delume.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.delume.domain.Patient;
import com.delume.dto.PatientNewDTO;
import com.delume.repositories.PatientRepository;
import com.delume.resources.exception.FieldMessage;

public class PatientInsertValidator implements ConstraintValidator<RegisterInsert, PatientNewDTO> {

	@Autowired
	private PatientRepository repo;
	
	@Override
	public void initialize(RegisterInsert ann) {
	}

	@Override
	public boolean isValid(PatientNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();

		Patient aux = repo.findByEmail(objDto.getEmail());
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