package com.doctorapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doctorapp.model.Doctor;
import com.doctorapp.service.IDoctorService;

@RestController
public class DoctorController {

	IDoctorService doctorService;
	@Autowired
	public void setDoctorService(IDoctorService doctorService) {
		this.doctorService = doctorService;
	}
	
//	http://localhost:8080/doctors/doctorId?doctorId=101	
	@GetMapping("/doctors/doctorId")
	Doctor getByID(@RequestParam("doctorId") int doctorId) {
		return doctorService.getByID(doctorId);
	}

//	http://localhost:8080/doctors/	
	@GetMapping("/doctors")
	List<Doctor> getAllDoctors(){
		return doctorService.getAllDoctors();
	}

//	http://localhost:8080/doctors/speciality/Cardiologist	
	@GetMapping("/doctors/speciality/{pathSpeciality}")
	List<Doctor> getBySpeciality(@PathVariable("pathSpeciality") String speciality){
		return doctorService.getBySpeciality(speciality);
	}

//	http://localhost:8080/doctors/speciality/Cardiologist/fees/4000	
	@RequestMapping(value = "/doctors/speciality/{pathSpeciality}/fees/{pathFees}", method=RequestMethod.GET)
	List<Doctor> getBySpecialityAndFees(@PathVariable("pathSpeciality")String speciality,@PathVariable("pathFees") double fees){
		return doctorService.getBySpecialityAndFees(speciality, fees);
	}

//	http://localhost:8080/doctors/speciality/Cardiologist/name/ya	
	@GetMapping("/doctors/speciality/{pathSpeciality}/name/{pathName}")
	List<Doctor> getBySpecialityName(@PathVariable("pathSpeciality")String speciality, @PathVariable("pathName")String name){
		return doctorService.getBySpecialityName(speciality, name);
	}
}
