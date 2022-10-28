package com.doctorapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.doctorapp.service.IDoctorService;

@SpringBootApplication
public class SpringDoctorappBasicApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringDoctorappBasicApplication.class, args);
	}

	@Autowired
	IDoctorService doctorService;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("All doctors: ");
		doctorService.getAllDoctors().forEach(System.out::println);
		System.out.println("\nGet by ID: ");
		System.out.println(doctorService.getByID(101));
		System.out.println("\nGet by Speciality: ");
		doctorService.getBySpeciality("Cardiologist").forEach(System.out::println);
		System.out.println("\nGet by Speciality and Fees: ");
		doctorService.getBySpecialityAndFees("Neurologist", 5000).forEach(System.out::println);
		System.out.println("\nGet by Speciality and Name: ");
		doctorService.getBySpecialityName("Cardiologist", "ya").forEach(System.out::println);		
	}

}
