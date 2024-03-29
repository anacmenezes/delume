package com.delume.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.delume.domain.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	@Transactional(readOnly=true)
	Patient findByEmail(String email);

}
