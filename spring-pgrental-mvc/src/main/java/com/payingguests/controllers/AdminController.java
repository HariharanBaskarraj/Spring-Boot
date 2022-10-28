package com.payingguests.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping("admin")
	public String adminPage(Model model) {
		return "admin";
	}
	
	@RequestMapping("addPgForm")
	public String addPayingGuest(Model model) {
		return "add-pg-form";
	}
	
	@RequestMapping("updatePgForm")
	public String showEditForm(Model model) {
		return "edit-form";
	}
	
	@RequestMapping("deletePgForm")
	public String deletePayingGuest(Model model) {
		return "delete-pg-form";
	}
}
