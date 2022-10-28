package com.doctorapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctorapp.model.Casesheet;
import com.doctorapp.model.Doctor;
import com.doctorapp.service.IDoctorService;

@RestController
@RequestMapping("doctor-api")
public class DoctorController {

	private IDoctorService doctorService;
	@Autowired
	public void setDoctorService(IDoctorService doctorService) {
		this.doctorService = doctorService;
	}
	
	/*
	 * { "doctorName": "Shreedhar", "doctorId": 107, "email": "shree@gmail.com",
	 * "address": { "addressId": 207, "location": "Rajaji Nagar", "city":
	 * "Bangalore", "state": "Karnataka" }, "speciality": [ { "specialityId": 301,
	 * "specialityName": "Pediatrician" }, { "specialityId": 302, "specialityName":
	 * "Cardiologist" } ], "hospital": { "hospitalId": 401, "hospitalName":
	 * "Malar Hospital", "city": "Bangalore" }, "casesheet": [ { "caseId": 501,
	 * "caseType": "Fever and Cough" }, { "caseId": 502, "caseType":
	 * "Vomiting and cold" } ], "fees": 600.0, "experience": 12 }
	 */
	//http://localhost:8080/doctor-api/doctors/
	@PostMapping("/doctors")
	ResponseEntity<Void> addDoctor(@RequestBody Doctor doctor) {
		doctorService.addDoctor(doctor);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	/*
	 * { "doctorName": "Shreedhar", "doctorId": 106, "email": "shree@gmail.com",
	 * "address": { "addressId": 207, "location": "Hari Nagar", "city": "Bangalore",
	 * "state": "Karnataka" }, "speciality": [ { "specialityId": 301,
	 * "specialityName": "Pediatrician" }, { "specialityId": 302, "specialityName":
	 * "Cardiologist" } ], "hospital": { "hospitalId": 401, "hospitalName":
	 * "Malar Hospital", "city": "Bangalore" }, "casesheet": [ { "caseId": 501,
	 * "caseType": "Fever and Cough" }, { "caseId": 502, "caseType":
	 * "Vomiting and cold" } ], "fees": 600.0, "experience": 12 }
	 */
	//http://localhost:8080/doctor-api/doctors/
	@PutMapping("/doctors")
	ResponseEntity<Void> updateDoctor(@RequestBody Doctor doctor) {
		doctorService.updateDoctor(doctor);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	//http://localhost:8080/doctor-api/doctors/id/106
	@DeleteMapping("/doctors/id/{id}")
	ResponseEntity<Void> deleteDoctor(@PathVariable("id")int doctorId) {
		doctorService.deleteDoctor(doctorId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	//http://localhost:8080/doctor-api/doctors/
	@GetMapping("/doctors")
	ResponseEntity<List<Doctor>> getAll() {
		List<Doctor> doctors = doctorService.getAllDoctors();
		return ResponseEntity.ok().body(doctors);
	}

	//http://localhost:8080/doctor-api/doctors/id/106
	@GetMapping("/doctors/id/{id}")
	ResponseEntity<Doctor> getByID(@PathVariable("id")int doctorId) {
		Doctor doctor = doctorService.getByID(doctorId);
		return ResponseEntity.ok().body(doctor);
	}

	/*
	 * { "caseId": 501, "caseType": "Fever and Cough" }
	 */
	//http://localhost:8080/doctor-api/doctors/casesheet
	@GetMapping("/doctors/casesheet")
	ResponseEntity<Doctor> getByCasesheet(@RequestBody Casesheet casesheet) {
		Doctor doctor = doctorService.getByCasesheet(casesheet);
		return ResponseEntity.ok().body(doctor);
	}

	//http://localhost:8080/doctor-api/doctors/city/Bangalore
	@GetMapping("/doctors/city/{city}")
	ResponseEntity<List<Doctor>> getByCity(@PathVariable("city") String city) {
		List<Doctor> doctors = doctorService.getByCity(city);
		return ResponseEntity.ok().body(doctors);
	}

	//http://localhost:8080/doctor-api/doctors/speciality/Cardiologist/city/Bangalore
	@GetMapping("/doctors/speciality/{speciality}/city/{city}")
	ResponseEntity<List<Doctor>> getBySpecialityAndCity(@PathVariable("speciality") String speciality,
			@PathVariable("city") String city) {
		List<Doctor> doctors = doctorService.getBySpecialityAndCity(speciality, city);
		return ResponseEntity.ok().body(doctors);
	}

	//http://localhost:8080/doctor-api/doctors/speciality/Cardiologist
	@GetMapping("/doctors/speciality/{speciality}")
	ResponseEntity<List<Doctor>> getBySpeciality(@PathVariable("speciality") String speciality) {
		List<Doctor> doctors = doctorService.getBySpeciality(speciality);
		return ResponseEntity.ok().body(doctors);
	}

	//http://localhost:8080/doctor-api/doctors/speciality/Cardiologist/experience/12
	@GetMapping("/doctors/speciality/{speciality}/experience/{experience}")
	ResponseEntity<List<Doctor>> getBySpecialityAndExperience(@PathVariable("speciality") String speciality,
			@PathVariable("experience") int experience) {
		List<Doctor> doctors = doctorService.getBySpecialityAndExperience(speciality, experience);
		return ResponseEntity.ok().body(doctors);
	}

	//http://localhost:8080/doctor-api/doctors/speciality/Cardiologist/fees/400
	@GetMapping("/doctors/speciality/{speciality}/fees/{fees}")
	ResponseEntity<List<Doctor>> getBySpecialityAndFees(@PathVariable("speciality") String speciality,
			@PathVariable("fees") double fees) {
		List<Doctor> doctors = doctorService.getBySpecialityAndFees(speciality, fees);
		return ResponseEntity.ok().body(doctors);
	}

	//http://localhost:8080/doctor-api/doctors/speciality/Cardiologist/hospital/Malar Hospital
	@GetMapping("/doctors/speciality/{speciality}/hospital/{hospital}")
	ResponseEntity<List<Doctor>> getBySpecialityAndHospital(@PathVariable("speciality") String speciality,
			@PathVariable("hospital") String hospitalName) {
		List<Doctor> doctors = doctorService.getBySpecialityAndHospital(speciality, hospitalName);
		return ResponseEntity.ok().body(doctors);
	}

	//http://localhost:8080/doctor-api/doctors/hospital/Malar Hospital
	@GetMapping("/doctors/hospital/{hospital}")
	ResponseEntity<List<Doctor>> getByHospital(@PathVariable("hospital") String hospitalName) {
		List<Doctor> doctors = doctorService.getByHospital(hospitalName);
		return ResponseEntity.ok().body(doctors);
	}

}
