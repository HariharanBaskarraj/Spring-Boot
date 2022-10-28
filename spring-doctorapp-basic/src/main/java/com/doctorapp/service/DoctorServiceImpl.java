package com.doctorapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctorapp.dao.IDoctorDto;
import com.doctorapp.model.Doctor;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	IDoctorDto doctorDto;

	@Override
	public Doctor getByID(int doctorId) {
		return doctorDto.findByID(doctorId);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		List<Doctor> doctors = doctorDto.findAllDoctors();
		if (doctors.isEmpty())
			throw new DoctorNotFoundException("Not found");
		return doctors.stream()
				.sorted((doctor1, doctor2) -> doctor1.getDoctorName().compareToIgnoreCase(doctor2.getDoctorName()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Doctor> getBySpeciality(String speciality) {
		List<Doctor> doctors = doctorDto.findBySpeciality(speciality);
		if (doctors.isEmpty())
			throw new DoctorNotFoundException("Not found");
		return doctors.stream()
				.sorted((doctor1, doctor2) -> doctor1.getDoctorName().compareToIgnoreCase(doctor2.getDoctorName()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Doctor> getBySpecialityAndFees(String speciality, double fees) {
		List<Doctor> doctors = doctorDto.findBySpecialityAndFees(speciality, fees);
		if (doctors.isEmpty())
			throw new DoctorNotFoundException("Not found");
		return doctors.stream()
				.sorted((doctor1, doctor2) -> ((Double) doctor1.getFees()).compareTo((Double) doctor2.getFees()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Doctor> getBySpecialityName(String speciality, String name) {
		List<Doctor> doctors = doctorDto.findBySpecialityName(speciality, name);
		if (doctors.isEmpty())
			throw new DoctorNotFoundException("Not found");
		return doctors.stream()
				.sorted((doctor1, doctor2) -> doctor1.getDoctorName().compareToIgnoreCase(doctor2.getDoctorName()))
				.collect(Collectors.toList());
	}

}
