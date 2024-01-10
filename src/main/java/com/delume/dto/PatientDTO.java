package com.delume.dto;

import java.io.Serializable;

public class PatientDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer cpf;
	private String name;
	private String phone;
	
	public PatientDTO() {
	}

	public PatientDTO(Integer id, Integer cpf, String name, String phone) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.name = name;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
