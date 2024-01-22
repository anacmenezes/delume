package com.delume;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.delume.domain.Address;
import com.delume.domain.Appointment;
import com.delume.domain.Employee;
import com.delume.domain.Patient;
import com.delume.domain.enums.Position;
import com.delume.domain.enums.Room;
import com.delume.repositories.AppointmentRepository;
import com.delume.repositories.EmployeeRepository;
import com.delume.repositories.PatientRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Delume", version = "1", description = "Saúde Integrada"))
public class DelumeApplication implements CommandLineRunner {

	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private AppointmentRepository appointmentRepository;


	public static void main(String[] args) {
		SpringApplication.run(DelumeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Address add1 = new Address("123456", "Street test1", "123", "Neighborhood test1", "RJ", "RJ");
		Patient pat1 = new Patient((long) 56278946102.0, "Test1", "test1@gmail.com", "2589463", add1);
		Employee emp1 = new Employee((long) 59876421587.0, "Test3", "2589463","test1@gmail.com", "adm123" , add1, Position.HEALTH);
		Appointment appo1 = new Appointment(null, null, "Test1", Room.TYPEONE);
		
		patientRepository.saveAll(Arrays.asList(pat1));
		employeeRepository.saveAll(Arrays.asList(emp1));
		appointmentRepository.saveAll(Arrays.asList(appo1));
		
	}
}
