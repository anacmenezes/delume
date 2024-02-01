package com.delume.dto;
import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.delume.domain.Patient;
import com.delume.services.validation.RegisterUpdate;

@RegisterUpdate
public class PatientDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Mandatory completion")
	private Long cpf;
	
	@NotEmpty(message="Mandatory completion")
	private String name;
	
	@NotEmpty(message="Mandatory completion")
	@Email(message="Invalid email")
	private String email;
	
	public PatientDTO() {
	}

	public PatientDTO(Patient obj) {
		cpf = obj.getCpf();
		name = obj.getName();
		email = obj.getEmail();
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}