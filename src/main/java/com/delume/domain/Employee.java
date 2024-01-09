package com.delume.domain;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer cpf;
	private String name;
	private String password;
	private Integer position;
	
	
	public Employee() {
	}

	public Employee(Integer id, Integer cpf, String name, String password, Integer position) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.name = name;
		this.password = password;
		this.position = position;
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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, id, name, password, position);
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
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(position, other.position);
	}
}

