package com.delume.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.delume.domain.Patient;
import com.delume.dto.PatientDTO;
import com.delume.services.PatientService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/patient", produces = {"application/json"})
@Tag(name = "patient")
public class PatientResource {
	
	@Autowired
	private PatientService service;
	
	@RequestMapping(value="/{cpf}", method=RequestMethod.GET)
	public ResponseEntity<Patient> find(@PathVariable Long cpf) {
		Patient obj = service.find(cpf);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody PatientDTO objDto) {
		Patient obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{cpf}").buildAndExpand(obj.getCpf()).toUri();
			return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value="/{cpf}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PatientDTO objDto, @PathVariable Long cpf) {
		Patient obj = service.fromDTO(objDto);
		obj.setCpf(cpf);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{cpf}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long cpf) {
		service.delete(cpf);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PatientDTO>> findAll() {
		List<Patient> list = service.findAll();
		List<PatientDTO> listDto = list.stream().map(obj -> new PatientDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}