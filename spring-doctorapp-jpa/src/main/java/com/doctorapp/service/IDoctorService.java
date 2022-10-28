package com.doctorapp.service;

import java.time.LocalDateTime;
import java.util.List;

import com.doctorapp.model.Doctor;

public interface IDoctorService {
	void addDoctor(Doctor doctor);

	void updateDoctor(Doctor doctor);

	Doctor getByID(int doctorId);

	void deleteDoctor(int doctorId);

	List<Doctor> getAllDoctors();

	List<Doctor> getBySpeciality(String speciality);

	List<Doctor> getBySpecialityAndExperience(String speciality, int experience);

	List<Doctor> getBySpecialityAndFees(String speciality, double fees);

	List<Doctor> getByAvailability(LocalDateTime startTime);

}
