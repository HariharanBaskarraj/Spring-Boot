package com.doctorapp.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.doctorapp.model.Doctor;
import com.doctorapp.service.DoctorNotFoundException;
import com.doctorapp.service.IDoctorService;

@Controller
public class DoctorController {
	
	private IDoctorService doctorService;
	public DoctorController(IDoctorService doctorService) {
		super();
		this.doctorService = doctorService;
	}


	@RequestMapping({"/","home"})
	public String homePage(Model model) {
		List<Doctor> doctors = doctorService.getAllDoctors();
		model.addAttribute("doctors",doctors);
		return "home";
	}
	
	@RequestMapping("add-doctor")
	public String addDoctor(Doctor doctor) {
		doctorService.addDoctor(doctor);
		return "admin";
	}
	
	@RequestMapping("/search-doctor")
	public String searchBySpeciality(@RequestParam("choice")String choice, Model model) {
		List<Doctor> doctors =doctorService.getBySpeciality(choice);
		model.addAttribute("doctors", doctors);
		return "home";
	}
	
	@RequestMapping("/getOne")
	public String searchById(@RequestParam("doctorId")int doctorId,Model model) {
		Doctor doctor=doctorService.getByID(doctorId);
		model.addAttribute(doctor);
		return "update-doctor-form";
	}
	
	@RequestMapping("update-doctor")
	public String updateDoctor(@RequestParam("doctorId")int doctorId,@RequestParam("fees")double fees, Model model) {
		doctorService.updateDoctor(doctorId, fees);
		return "admin";
	}
	
	@ExceptionHandler(DoctorNotFoundException.class)
	public String handleDoctorException(Model model, Exception e) {
		model.addAttribute("message", e.getMessage());
		return "home";
		//	return "redirect:home";
	}

}
