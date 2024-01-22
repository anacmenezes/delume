package com.delume.dto;

import java.io.Serializable;
import java.util.Date;

import com.delume.domain.Appointment;

public class AppointmentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date date;
	private String informations;
	private String room;
	
	public AppointmentDTO() {
	}

	public AppointmentDTO(Appointment obj) {
		id = obj.getId();
		date = obj.getDate();
		informations = obj.getInformations();
		room = obj.getRoom();
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
		return informations;
	}

	public void setInformations(String informations) {
		this.informations = informations;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}
}