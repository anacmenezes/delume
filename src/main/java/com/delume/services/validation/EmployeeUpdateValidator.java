package com.delume.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.delume.domain.Employee;
import com.delume.dto.EmployeeDTO;
import com.delume.repositories.EmployeeRepository;
import com.delume.resources.exception.FieldMessage;

public class EmployeeUpdateValidator implements ConstraintValidator<RegisterUpdate, EmployeeDTO> {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public void initialize(RegisterUpdate ann) {
	}

	@Override
	public boolean isValid(EmployeeDTO objDto, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		
		Employee aux = repo.findByEmail(objDto.getEmail());
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