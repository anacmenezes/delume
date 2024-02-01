package com.delume.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.delume.domain.Patient;
import com.delume.dto.PatientDTO;
import com.delume.repositories.PatientRepository;
import com.delume.resources.exception.FieldMessage;

public class PatientUpdateValidator implements ConstraintValidator<RegisterUpdate, PatientDTO> {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private PatientRepository repo;
	
	@Override
	public void initialize(RegisterUpdate ann) {
	}

	@Override
	public boolean isValid(PatientDTO objDto, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		
		Patient aux = repo.findByEmail(objDto.getEmail());
		if (aux != null && !aux.getEmail().equals(uriId)) {
			list.add(new FieldMessage("email", "Email já existente"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}