package com.delume.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MedicalRecords implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Date date;
	private String Informations;
	
	public MedicalRecords() {
	}

	public MedicalRecords(Integer id, Date date, String informations) {
		super();
		this.id = id;
		this.date = date;
		Informations = informations;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getInformations() {
		return Informations;
	}

	public void setInformations(String informations) {
		Informations = informations;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Informations, date, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedicalRecords other = (MedicalRecords) obj;
		return Objects.equals(Informations, other.Informations) && Objects.equals(date, other.date)
				&& Objects.equals(id, other.id);
	}
}