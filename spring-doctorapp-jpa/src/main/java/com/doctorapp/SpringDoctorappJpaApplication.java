package com.doctorapp;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.doctorapp.service.IDoctorService;

@SpringBootApplication
public class SpringDoctorappJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDoctorappJpaApplication.class, args);
	}
	
	IDoctorService doctorService;
	@Autowired
	public void setDoctorService(IDoctorService doctorService) {
		this.doctorService = doctorService;
	}
	
	@Override
	public void run(String... args) throws Exception {

//		System.out.println("Adding...");
//		doctorService.addDoctor(new Doctor("Karuppiah", Specialisation.CARDIO.type, 6000, 35,LocalDateTime.of(2022, 10, 19, 9, 30), LocalDateTime.of(2022, 10, 19, 17, 45)));
//		doctorService.addDoctor(new Doctor("Meenakshi Sundaram", Specialisation.NEURO.type, 4500, 32,LocalDateTime.of(2022, 10, 19, 10, 30), LocalDateTime.of(2022, 10, 19, 19, 45)));
//		doctorService.addDoctor(new Doctor("Ramalingam", Specialisation.OPTHAL.type, 1200, 18,LocalDateTime.of(2022, 10, 19, 9, 30), LocalDateTime.of(2022, 10, 19, 17, 45)));
//		doctorService.addDoctor(new Doctor("Mohandass Gandhi", Specialisation.PEDO.type, 700, 25,LocalDateTime.of(2022, 10, 19, 10, 30), LocalDateTime.of(2022, 10, 19, 18, 45)));
//		doctorService.addDoctor(new Doctor("Jeyaprabha", Specialisation.DERMA.type, 2200, 9,LocalDateTime.of(2022, 10, 19, 9, 30), LocalDateTime.of(2022, 10, 19, 17, 45)));
//		doctorService.addDoctor(new Doctor("Ashwin", Specialisation.CARDIO.type, 3000, 8,LocalDateTime.of(2022, 10, 19, 10, 30), LocalDateTime.of(2022, 10, 19, 19, 45)));
//		doctorService.addDoctor(new Doctor("Roshan", Specialisation.NEURO.type, 2500, 12,LocalDateTime.of(2022, 10, 19, 9, 30), LocalDateTime.of(2022, 10, 19, 17, 45)));
//		doctorService.addDoctor(new Doctor("Hari", Specialisation.CARDIO.type, 1800, 18,LocalDateTime.of(2022, 10, 19, 10, 30), LocalDateTime.of(2022, 10, 19, 18, 45)));
//		doctorService.addDoctor(new Doctor("Mridhula", Specialisation.NEURO.type, 4800, 20,LocalDateTime.of(2022, 10, 19, 9, 30), LocalDateTime.of(2022, 10, 19, 17, 45)));
		
//		System.out.println("\nUpdating...");
//		Doctor doctor =doctorService.getByID(110);
//		doctor.setExperience(5);
//		doctorService.updateDoctor(doctor);
//		System.out.println("\nDeleting...");
//		doctorService.deleteDoctor(111);
		
		System.out.println("All doctors:");
		doctorService.getAllDoctors().forEach(System.out::println);
		System.out.println("\nBy ID: ");
		System.out.println(doctorService.getByID(102));
		System.out.println("\nBy Speciality: ");
		doctorService.getBySpeciality("Cardiologist").forEach(System.out::println);
		System.out.println("\nBy Speciality And Experience: ");
		doctorService.getBySpecialityAndExperience("Cardiologist", 35).forEach(System.out::println);
		System.out.println("\nBy Speciality And Fees: ");
		doctorService.getBySpecialityAndFees("Dermatologist", 2200).forEach(System.out::println);
		System.out.println("\nBy Availability: ");
		doctorService.getByAvailability(LocalDateTime.of(2022, 10, 10, 9, 30)).forEach(System.out::println);

	}

}
