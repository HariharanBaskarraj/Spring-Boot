/**
 * 
 */
package com.doctorapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctorapp.model.Speciality;
import com.doctorapp.service.ISpecialityService;

/**
 * @author HariharanB
 *
 */
@RestController
@RequestMapping("doctor-api")
public class SpecialityController {

	private ISpecialityService specialityService;

	@Autowired
	public void setHospitalService(ISpecialityService specialityService) {
		this.specialityService = specialityService;
	}

	@PostMapping("/specialities")
	ResponseEntity<Void> addSpeciality(Speciality speciality) {
		specialityService.addSpeciality(speciality);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping("/specialities")
	ResponseEntity<Void> updateSpeciality(Speciality speciality) {
		specialityService.updateSpeciality(speciality);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping("/specialities/id/{id}")
	ResponseEntity<Speciality> getById(int specialityId) {
		Speciality speciality = specialityService.getById(specialityId);
		return ResponseEntity.ok().body(speciality);
	}

	@DeleteMapping("/specialities/id/{id}")
	ResponseEntity<Void> deleteSpeciality(int specialityId) {
		specialityService.deleteSpeciality(specialityId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping("/specialities")
	ResponseEntity<List<Speciality>> getAll() {
		List<Speciality> specialities = specialityService.getAll();
		return ResponseEntity.ok().body(specialities);
	}

	@GetMapping("/specialities/doctor/{doctorName}")
	ResponseEntity<List<Speciality>> getByDoctor(String doctorName) {
		List<Speciality> specialities = specialityService.getByDoctor(doctorName);
		return ResponseEntity.ok().body(specialities);
	}

	@GetMapping("/specialities/hospital/{hospital}/doctor/{doctorName}")
	ResponseEntity<List<Speciality>> getByHospitalAndDoctor(String hospital, String doctor) {
		List<Speciality> specialities = specialityService.getByHospitalAndDoctor(hospital, doctor);
		return ResponseEntity.ok().body(specialities);
	}
}
