package com.payingguests.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.payingguests.model.PayingGuest;
import com.payingguests.service.IPayingGuestService;

@Controller
public class PayingGuestController {

	private IPayingGuestService payingGuestService;
	public PayingGuestController(IPayingGuestService payingGuestService) {
		super();
		this.payingGuestService = payingGuestService;
	}

	@RequestMapping("add-pg")
	public String addPayingGuest(PayingGuest payingGuest) {
		payingGuestService.addPayingGuest(payingGuest);
		return "admin";
	}

	@RequestMapping({"/","home"})
	public String showAll(Model model) {
		List<PayingGuest> payingGuests = payingGuestService.getAllPayingGuest();
		model.addAttribute("payingGuests", payingGuests);
		return "home";
	}

	@RequestMapping("pg-category")
	public String searchByCategory(@RequestParam("choice") String choice, Model model) {
		List<PayingGuest> payingGuests = payingGuestService.getPayingGuestByCategory(choice);
		model.addAttribute("payingGuests", payingGuests);
		return "home";
	}
	
	@RequestMapping("pg-location")
	public String searchByLocation(@RequestParam("choice") String choice, Model model) {
		List<PayingGuest> payingGuests = payingGuestService.getPayingGuestByLocation(choice);
		model.addAttribute("payingGuests", payingGuests);
		return "home";
	}
	
	@RequestMapping("getSpecific")
	public String searchById(@RequestParam("payingGuestId")int payingGuestId,Model model) {
		PayingGuest payingGuest=payingGuestService.getPayingGuestById(payingGuestId);
		model.addAttribute(payingGuest);
		return "update-pg-form";
	}
	
	@RequestMapping("delete-pg")
	public String deletePayingGuest(@RequestParam("payingGuestId")int payingGuestId) {
		payingGuestService.deletePayingGuest(payingGuestId);
		return "admin";
	}
	
	@RequestMapping("update-pg")
	public String updatePayingGuest(@RequestParam("payingGuestId")int payingGuestId,@RequestParam("category")String category, Model model) {
		payingGuestService.updatePayingGuest(payingGuestId, category);
		return "admin";
	}
	
	
}
