package com.delume.services.authorization;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delume.domain.Employee;
import com.delume.repositories.EmployeeRepository;
import com.delume.services.exception.ObjectNotFoundException;

@Service
public class AuthService {

	@Autowired
	private EmployeeRepository employeeRepository;

	private Random rand = new Random();

	public void sendNewPassword(String email) {
		
		Employee employee = employeeRepository.findByEmail(email);
		if (employee == null) {
			throw new ObjectNotFoundException("Email not found");
		}
		
		String newPass = newPassword();
		employee.setPassword(newPass);
		
		employeeRepository.save(employee);
	}

	private String newPassword() {
		char[] vet = new char[10];
		for (int i=0; i<10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		if (opt == 0) { 
			return (char) (rand.nextInt(10) + 48);
		}
		else if (opt == 1) {
			return (char) (rand.nextInt(26) + 65);
		}
		else {
			return (char) (rand.nextInt(26) + 97);
		}
	}
}