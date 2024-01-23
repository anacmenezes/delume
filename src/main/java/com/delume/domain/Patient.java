package com.delume.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long cpf;
	private String name;
	private String email;
	private String phone;
	private Address address;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "PATIENT_EMPLOYEE",
		joinColumns = @JoinColumn(name = "patient_id"),
		inverseJoinColumns = @JoinColumn(name = "employee_id")
	)
	private List<Employee> employee = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="patient")
	private List<Appointment> appointment = new ArrayList<>();
	
	public Patient() {
	}

	public Patient(Long cpf, String name, String email, String phone, Address address) {
		super();
		this.cpf = cpf;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
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
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	public List<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, cpf, email, name, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(address, other.address) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(phone, other.phone);
	}
}