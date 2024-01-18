package com.delume.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delume.domain.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
