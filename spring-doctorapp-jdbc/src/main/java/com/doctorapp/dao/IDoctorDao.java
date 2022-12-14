package com.doctorapp.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.doctorapp.model.Doctor;

public interface IDoctorDao {
	void addDoctor(Doctor doctor);

	void updateDoctor(int doctorId, double fees);

	Doctor findByID(int doctorId);

	void deleteDoctor(int doctorId);

	List<Doctor> findAllDoctors();

	List<Doctor> findBySpeciality(String speciality);

	List<Doctor> findBySpecialityAndExperience(String speciality, int experience);

	List<Doctor> findBySpecialityAndFees(String speciality, double fees);

	List<Doctor> findByAvailability(LocalDateTime startTime);

}
