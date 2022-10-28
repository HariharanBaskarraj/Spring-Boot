package com.doctorapp.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doctorapp.model.Doctor;
import com.doctorapp.service.DoctorNotFoundException;
import com.doctorapp.util.DoctorDetails;

/**
 * @author HariharanB
 *
 */

@Component
public class DoctorDtoImpl implements IDoctorDto {

	@Autowired
	DoctorDetails doctorDetails;

	@Override
	public Doctor findByID(int doctorId) {
		return doctorDetails.getDoctors().stream().filter(doctor -> doctor.getDoctorId() == doctorId).findFirst()
				.orElseThrow(() -> new DoctorNotFoundException("Not found"));
	}

	@Override
	public List<Doctor> findAllDoctors() {
		return doctorDetails.getDoctors();
	}

	@Override
	public List<Doctor> findBySpeciality(String speciality) {
		return doctorDetails.getDoctors().stream().filter(doctor -> doctor.getSpeciality().equalsIgnoreCase(speciality))
				.collect(Collectors.toList());
	}

	@Override
	public List<Doctor> findBySpecialityAndFees(String speciality, double fees) {
		return doctorDetails.getDoctors().stream()
				.filter(doctor -> doctor.getSpeciality().equalsIgnoreCase(speciality) && doctor.getFees() < fees)
				.collect(Collectors.toList());
	}

	@Override
	public List<Doctor> findBySpecialityName(String speciality, String name) {
		return doctorDetails.getDoctors().stream().filter(
				doctor -> doctor.getSpeciality().equalsIgnoreCase(speciality) && doctor.getDoctorName().contains(name))
				.collect(Collectors.toList());
	}

}
