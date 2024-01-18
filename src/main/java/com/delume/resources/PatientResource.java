package com.delume.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/patient", produces = {"application/json"})
@Tag(name = "patient")
public class PatientResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
	return "REST working!";
	}

}