package com.delume.domain;

import java.io.Serializable;
import java.util.Objects;

public class Appointment implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer date;
	private String informations;
//	Patient
//	Employee
//	Room

	public Appointment() {
	}

	public Appointment(Integer id, Integer date, String informations) {
		super();
		this.id = id;
		this.date = date;
		this.informations = informations;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDate() {
		return date;
	}

	public void setDate(Integer date) {
		this.date = date;
	}

	public String getInformations() {
		return informations;
	}

	public void setInformations(String informations) {
		this.informations = informations;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, id, informations);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		return Objects.equals(date, other.date) && Objects.equals(id, other.id)
				&& Objects.equals(informations, other.informations);
	}
}
