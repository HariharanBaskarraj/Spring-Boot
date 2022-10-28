/**
 * 
 */
package com.doctorapp.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doctorapp.model.Doctor;
import com.doctorapp.service.IDoctorService;

/**
 * @author HariharanB
 *
 */
@RestController
@RequestMapping("doctor-api")
public class DoctorController {

	private IDoctorService doctorService;
	@Autowired
	public void setDoctorService(IDoctorService doctorService) {
		this.doctorService = doctorService;
	}
	
//	http://localhost:8080/doctor-api/doctors/
	@PostMapping("/doctors")
	ResponseEntity<Void> addDoctor(@RequestBody Doctor doctor) {
		doctorService.addDoctor(doctor);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
//	http://localhost:8080/doctor-api/doctors/
	@PutMapping("/doctors")
	ResponseEntity<Void> updateDoctor(@RequestBody Doctor doctor) {
		doctorService.updateDoctor(doctor);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
//	http://localhost:8080/doctor-api/doctors/112	
	@DeleteMapping("/doctors/{doctorId}")
	ResponseEntity<Void> deleteDoctor(@PathVariable("doctorId") int doctorId) {
		doctorService.deleteDoctor(doctorId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

//	http://localhost:8080/doctor-api/doctors/doctorId/108	
	@GetMapping("/doctors/doctorId/{doctorId}")
	ResponseEntity<Doctor> getByID(@PathVariable("doctorId") int doctorId) {
		HttpHeaders header =new HttpHeaders();
		header.add("desc","Get by id"+ doctorId);
		return ResponseEntity.ok().headers(header).body(doctorService.getByID(doctorId));
	}

//	http://localhost:8080/doctor-api/doctors/	
	@GetMapping("/doctors")
	ResponseEntity<List<Doctor>>  getAllDoctors(){
		HttpHeaders header =new HttpHeaders();
		header.add("desc","Get all doctors");
		return ResponseEntity.ok().headers(header).body(doctorService.getAllDoctors());
	}

//	http://localhost:8080/doctor-api/doctors/speciality/Cardiologist	
	@GetMapping("/doctors/speciality/{speciality}")
	ResponseEntity<List<Doctor>> getBySpeciality(@PathVariable("speciality") String speciality){
		HttpHeaders header =new HttpHeaders();
		header.add("desc","Get By Speciality");
		return ResponseEntity.ok().headers(header).body(doctorService.getBySpeciality(speciality));
	}

//	http://localhost:8080/doctor-api/doctors/speciality/Cardiologist/experience/8	
	@GetMapping("/doctors/speciality/{speciality}/experience/{experience}")
	ResponseEntity<List<Doctor>> getBySpecialityAndExperience(@PathVariable("speciality") String speciality,@PathVariable("experience") int experience){
		HttpHeaders header =new HttpHeaders();
		header.add("desc"," Get By Speciality "+speciality+" and Experience "+experience);
		return ResponseEntity.ok().headers(header).body(doctorService.getBySpecialityAndExperience(speciality, experience));
	}
	
//	http://localhost:8080/doctor-api/doctors/speciality/Cardiologist/fees/3000
	@GetMapping("/doctors/speciality/{speciality}/fees/{fees}")
	ResponseEntity<List<Doctor>> getBySpecialityAndFees(@PathVariable("speciality") String speciality,@PathVariable("fees") double fees){
		HttpHeaders header =new HttpHeaders();
		header.add("desc","getBySpeciality "+speciality+" And Fees "+fees);
		return ResponseEntity.ok().headers(header).body(doctorService.getBySpecialityAndFees(speciality, fees));
	}

//	http://localhost:8080/doctor-api/doctors/availability?availability=2022-10-19T10:30:00	
	@GetMapping("/doctors/availability")
	ResponseEntity<List<Doctor>> getByAvailability(@RequestParam ("availability") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") LocalDateTime startTime){
		HttpHeaders header =new HttpHeaders();
		header.add("desc","Get By Availability "+startTime);
		return ResponseEntity.ok().headers(header).body(doctorService.getByAvailability(startTime));
	}
}
