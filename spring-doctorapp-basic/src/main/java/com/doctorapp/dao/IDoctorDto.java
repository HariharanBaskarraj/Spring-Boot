package com.doctorapp.dao;

import java.util.List;

import com.doctorapp.model.Doctor;

public interface IDoctorDto {

	Doctor findByID(int doctorId);

	List<Doctor> findAllDoctors();

	List<Doctor> findBySpeciality(String speciality);

	List<Doctor> findBySpecialityAndFees(String speciality, double fees);

	List<Doctor> findBySpecialityName(String speciality, String name);

}
