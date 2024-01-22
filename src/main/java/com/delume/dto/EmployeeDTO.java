package com.delume.dto;

import java.io.Serializable;

import com.delume.domain.Address;
import com.delume.domain.Employee;

public class EmployeeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long cpf;
	private String name;
	private String phone;
	private String email;
	private String password;
	private Address address;
	private String position;
	
	public EmployeeDTO() {
	}

	public EmployeeDTO(Employee obj) {
		cpf = obj.getCpf();
		name = obj.getName();
		phone = obj.getPhone();
		email = obj.getEmail();
		password = obj.getPassword();
		address = obj.getAddress();	
		position = obj.getPosition();
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
}