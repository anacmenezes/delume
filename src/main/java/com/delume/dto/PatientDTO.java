package com.delume.dto;

import java.io.Serializable;

import com.delume.domain.Address;
import com.delume.domain.Patient;

public class PatientDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer cpf;
	private String name;
	private String email;
	private String phone;
	private Address address;
	
	public PatientDTO() {
	}

	public PatientDTO(Patient obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
		phone = obj.getPhone();
		address = obj.getAddress();	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
