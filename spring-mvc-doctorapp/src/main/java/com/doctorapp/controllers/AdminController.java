package com.doctorapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping("admin")
	public String adminPage(Model model) {
		return "admin";
	}
	
	@RequestMapping("addDoctorForm")
	public String addDoctor(Model model) {
		return "add-doctor-form";
	}
	
	@RequestMapping("updateDoctorForm")
	public String showEditForm(Model model) {
		return "edit-form";
	}
}
