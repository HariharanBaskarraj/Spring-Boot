package com.doctorapp;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.doctorapp.service.IDoctorService;

@SpringBootApplication
public class SpringDoctorappJdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDoctorappJdbcApplication.class, args);
	}

	@Autowired
	IDoctorService doctorService;

	public SpringDoctorappJdbcApplication(IDoctorService doctorService) {
		super();
		this.doctorService = doctorService;
	}

	@Override
	public void run(String... args) throws Exception {
//		doctorService.addDoctor(new Doctor("Ashwin", Specialisation.CARDIO.type, 1500, 3,
//		LocalDateTime.of(2022, 10, 10, 9, 30), LocalDateTime.of(2022, 10, 10, 17, 45)));
//		doctorService.updateDoctor(30, 2000);
//		doctorService.deleteDoctor(31);
		System.out.println("All doctors:");
		doctorService.getAllDoctors().forEach(System.out::println);
		System.out.println("\nBy ID: ");
		System.out.println(doctorService.getByID(12));
		System.out.println("\nBy Speciality: ");
		doctorService.getBySpeciality("Cardiologist").forEach(System.out::println);
		System.out.println("\nBy Speciality And Experience: ");
		doctorService.getBySpecialityAndExperience("Cardiologist", 35).forEach(System.out::println);
		System.out.println("\nBy Speciality And Fees: ");
		doctorService.getBySpecialityAndFees("Dermatologist", 1800).forEach(System.out::println);
		System.out.println("\nBy Availability: ");
		doctorService.getByAvailability(LocalDateTime.of(2022, 10, 10, 9, 30)).forEach(System.out::println);
	}

}
