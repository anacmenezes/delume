package com.delume.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delume.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {

}
