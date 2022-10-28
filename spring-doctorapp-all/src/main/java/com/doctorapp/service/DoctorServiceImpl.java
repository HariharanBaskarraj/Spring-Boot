package com.doctorapp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctorapp.model.Casesheet;
import com.doctorapp.model.Doctor;
import com.doctorapp.repository.IDoctorRepository;
@Service
public class DoctorServiceImpl implements IDoctorService {

	IDoctorRepository doctorRepository;
	
	@Autowired	
	public void setDoctorRepository(IDoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}

	@Override
	public void addDoctor(Doctor doctor) {
		doctorRepository.save(doctor);
	}

	@Override
	public void updateDoctor(Doctor doctor) {
		doctorRepository.save(doctor);
	}

	@Override
	public Doctor getByID(int doctorId) {
		return doctorRepository.findById(doctorId).get();
	}

	@Override
	public void deleteDoctor(int doctorId) {
		doctorRepository.deleteById(doctorId);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	@Override
	public List<Doctor> getByCity(String city) {
		return doctorRepository.findByCity(city);
	}

	@Override
	public List<Doctor> getBySpecialityAndCity(String speciality, String city) {
		return doctorRepository.findBySpecialityAndCity(speciality, city);
	}

	@Override
	public List<Doctor> getBySpeciality(String speciality) {
		return doctorRepository.findBySpeciality(speciality);
	}

	@Override
	public List<Doctor> getBySpecialityAndExperience(String speciality, int experience) {
		return doctorRepository.findBySpecialityAndExperience(speciality, experience);
	}

	@Override
	public List<Doctor> getBySpecialityAndFees(String speciality, double fees) {
		return doctorRepository.findBySpecialityAndFees(speciality, fees);
	}

	@Override
	public List<Doctor> getBySpecialityAndHospital(String speciality, String hospitalName) {
		return doctorRepository.findBySpecialityAndHospital(speciality, hospitalName);
	}

	@Override
	public List<Doctor> getByHospital(String hospitalName) {
		return doctorRepository.findByHospital(hospitalName);
	}

	@Override
	public Doctor getByCasesheet(Casesheet casesheet) {
		return doctorRepository.findByCasesheet(casesheet);
	}

}
