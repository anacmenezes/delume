package com.delume.domain;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String street;
	private String number;
	private String neighborhood;
	private String state;
	private String city;
	private String cep;
	
	public Address() {
	}

	public Address(Integer id, String street, String number, String neighborhood, String state, String city,
			String cep) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.neighborhood = neighborhood;
		this.state = state;
		this.city = city;
		this.cep = cep;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, city, id, neighborhood, number, state, street);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(city, other.city) && Objects.equals(id, other.id)
				&& Objects.equals(neighborhood, other.neighborhood) && Objects.equals(number, other.number)
				&& Objects.equals(state, other.state) && Objects.equals(street, other.street);
	}
}
