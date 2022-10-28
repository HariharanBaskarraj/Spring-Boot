package com.doctorapp.model;

public enum Specialisation {
	
	GENERAL("General Physician"),
	CARDIO("Cardiologist"),
	NEURO("Neurologist"),
	PEDO("Pediatrician"),
	DERMA("Dermatologist"),
	OPTHAL("Opthalmologist");
	
	private String specialityName;

	private Specialisation(String specialityName) {
		this.specialityName = specialityName;
	}

	public String getSpecialityName() {
		return specialityName;
	}
	
}
