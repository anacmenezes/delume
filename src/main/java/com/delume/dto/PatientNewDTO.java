package com.delume.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.delume.services.validation.RegisterInsert;

@RegisterInsert
public class PatientNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Mandatory completion")
	private Long cpf;
	@NotEmpty(message="Mandatory completion")
	private String name;
	@NotEmpty(message="Mandatory completion")
	@Email(message="Invalid email")
	private String email;
	@NotEmpty(message="Mandatory completion")
	private String phone;
	@NotEmpty(message="Mandatory completion")
	private String cep;
	@NotEmpty(message="Mandatory completion")
	private String street;
	@NotEmpty(message="Mandatory completion")
	private String number;
	@NotEmpty(message="Mandatory completion")
	private String neighborhood;
	@NotEmpty(message="Mandatory completion")
	private String city;
	@NotEmpty(message="Mandatory completion")
	private String state;
	
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}