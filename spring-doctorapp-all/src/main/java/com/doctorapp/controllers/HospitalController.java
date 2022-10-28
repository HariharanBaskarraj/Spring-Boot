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

import com.doctorapp.model.Hospital;
import com.doctorapp.service.IHospitalService;

/**
 * @author HariharanB
 *
 */
@RestController
@RequestMapping("doctor-api")
public class HospitalController {

	private IHospitalService hospitalService;

	@Autowired
	public void setHospitalService(IHospitalService hospitalService) {
		this.hospitalService = hospitalService;
	}

	//http://localhost:8080/doctor-api/hospitals
	@PostMapping("/hospitals")
	ResponseEntity<Void> addHospital(@RequestBody Hospital hospital) {
		hospitalService.addHospital(hospital);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	//http://localhost:8080/doctor-api/hospitals
	@PutMapping("/hospitals")
	ResponseEntity<Void> updateHospital(@RequestBody Hospital hospital) {
		hospitalService.updateHospital(hospital);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	//http://localhost:8080/doctor-api/hospitals
	@GetMapping("/hospitals")
	ResponseEntity<List<Hospital>> getAll() {
		List<Hospital> hospitals = hospitalService.getAll();
		return ResponseEntity.ok().body(hospitals);
	}

	//http://localhost:8080/doctor-api/hospitals/id/401
	@GetMapping("/hospitals/id/{id}")
	ResponseEntity<Hospital> getById(@PathVariable("id") int hospitalId) {
		Hospital hospital = hospitalService.getById(hospitalId);
		return ResponseEntity.ok().body(hospital);
	}

	//http://localhost:8080/doctor-api/hospitals/id/401
	@DeleteMapping("/hospitals/id/{id}")
	ResponseEntity<Void> deleteHospital(@PathVariable("id") int hospitalId) {
		hospitalService.deleteHospital(hospitalId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	//http://localhost:8080/doctor-api/hospitals/city/Bangalore
	@GetMapping("/hospitals/city/{city}")
	ResponseEntity<List<Hospital>> getByCity(@PathVariable("city") String city) {
		List<Hospital> hospitals = hospitalService.getByCity(city);
		return ResponseEntity.ok().body(hospitals);
	}

	//http://localhost:8080/doctor-api/hospitals/speciality/Cardiologist/city/Bangalore
	@GetMapping("/hospitals/speciality/{speciality}/city/{city}")
	ResponseEntity<List<Hospital>> getBySpecialityAndCity(@PathVariable("speciality") String speciality,
			@PathVariable("city") String city) {
		List<Hospital> hospitals = hospitalService.getBySpecialityAndCity(speciality, city);
		return ResponseEntity.ok().body(hospitals);
	}

	//http://localhost:8080/doctor-api/hospitals/speciality/Cardiologist
	@GetMapping("/hospitals/speciality/{speciality}")
	ResponseEntity<List<Hospital>> getBySpeciality(@PathVariable("speciality") String speciality) {
		List<Hospital> hospitals = hospitalService.getBySpeciality(speciality);
		return ResponseEntity.ok().body(hospitals);
	}

	//http://localhost:8080/doctor-api/hospitals/speciality/Cardiologist/experience/3
	@GetMapping("/hospitals/speciality/{speciality}/experience/{experience}")
	ResponseEntity<List<Hospital>> getBySpecialityAndExp(@PathVariable("speciality") String speciality,
			@PathVariable("experience") int experience) {
		List<Hospital> hospitals = hospitalService.getBySpeciality(speciality);
		return ResponseEntity.ok().body(hospitals);
	}


	//http://localhost:8080/doctor-api/hospitals/doctor/Shreedhar
	@GetMapping("/hospitals/doctor/{doctorName}")
	ResponseEntity<List<Hospital>> getByDoctor(@PathVariable("doctorName") String doctorName) {
		List<Hospital> hospitals = hospitalService.getByDoctor(doctorName);
		return ResponseEntity.ok().body(hospitals);
	}

	//http://localhost:8080/doctor-api/hospitals/speciality/Cardiologist/doctor/Shreedhar
	@GetMapping("/hospitals/speciality/{speciality}/doctor/{doctorName}")
	ResponseEntity<List<Hospital>> getBySpecialityAndDoctor(@PathVariable("speciality") String speciality,
			String doctor) {
		List<Hospital> hospitals = hospitalService.getBySpecialityAndDoctor(speciality, doctor);
		return ResponseEntity.ok().body(hospitals);
	}

	//http://localhost:8080/doctor-api/hospitals/name/Malar Hospital
	@GetMapping("/hospitals/name/{hospitalName}")
	ResponseEntity<List<Hospital>> getByHospital(@PathVariable("hospitalName") String hospitalName) {
		List<Hospital> hospitals = hospitalService.getByHospital(hospitalName);
		return ResponseEntity.ok().body(hospitals);
	}
}
