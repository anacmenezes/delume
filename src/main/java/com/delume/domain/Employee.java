package com.delume.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.delume.domain.enums.Position;

@Entity
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long cpf;
	private String name;
	private String phone;
	private String email;
	private String password;
	private Address address;
	private String position;
	
	public Employee() {
	}

	public Employee(Long cpf, String name, String phone, String email, String password, Address address,
			Position position) {
		super();
		this.cpf = cpf;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.address = address;
		this.position = (position==null) ? null : position.getdescription();
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, cpf, email, name, password, phone, position);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(address, other.address) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(phone, other.phone)
				&& Objects.equals(position, other.position);
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