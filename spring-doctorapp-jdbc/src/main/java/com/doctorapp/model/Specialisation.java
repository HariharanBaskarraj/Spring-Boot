package com.doctorapp.model;

public enum Specialisation {
	CARDIO("Cardiologist"),
	NEURO("Neurologist"),
	PEDO("Pediatrician"),
	DERMA("Dermatologist"),
	OPTHAL("Opthalmologist");
	
	public String type;
	
	private Specialisation(String type) {
		this.type=type;
	}
	
}
