package com.delume.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.delume.domain.Appointment;
import com.delume.dto.AppointmentDTO;
import com.delume.services.AppointmentService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/appointment", produces = {"application/json"})
@Tag(name = "appointment")
public class AppointmentResource {
	
	@Autowired
	private AppointmentService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Appointment> find(@PathVariable Integer id) {
		Appointment obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody AppointmentDTO objDto) {
		Appointment obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody AppointmentDTO objDto, @PathVariable Integer id) {
		Appointment obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping
	public ResponseEntity<List<AppointmentDTO>> findAll() {
		List<Appointment> list = service.findAll();
		List<AppointmentDTO> listDto = list.stream().map(obj -> new AppointmentDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}