package com.example.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	@GetMapping("/greet")
	public String greet() {
		return "Great day";
	}
	
	@GetMapping("/")
	public String home() {
		return "Online Shopping";
	}
	
	@GetMapping("/admin/add")
	public String addBook() {
		return "Book added";
	}
	
	@GetMapping("/admin/update")
	public String updateBook() {
		return "Book updated";
	}
	@GetMapping("/books/show")
	public List<String> showBooks() {
		return Arrays.asList("Secret","5am Club","Leadership");
	}
}