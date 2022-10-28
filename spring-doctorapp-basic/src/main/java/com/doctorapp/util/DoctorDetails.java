package com.doctorapp.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.doctorapp.model.Doctor;
import com.doctorapp.model.Specialisation;

@Component
public class DoctorDetails {

	private List<Doctor> doctors = showDoctors();

	public List<Doctor> getDoctors() {
		return doctors;
	}

	private List<Doctor> showDoctors() {
		return Arrays.asList(new Doctor("Karuppaiah", 101, Specialisation.CARDIO.type, 5000),
				new Doctor("Meenakshi Sundaram", 102, Specialisation.NEURO.type, 4000),
				new Doctor("Jaya", 103, Specialisation.CARDIO.type, 3500),
				new Doctor("Rexline", 104, Specialisation.DERMA.type, 700),
				new Doctor("Karunya", 105, Specialisation.PEDO.type, 850),
				new Doctor("Mridhula", 106, Specialisation.NEURO.type, 4500));
	}

}
