package com.doctorapp.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<Doctor> getAllDoctors() {
		List<Doctor> doctors = doctorRepository.findAll();
		
		if (doctors.isEmpty())
			throw new DoctorNotFoundException("Doctors not available.");
		
		return doctors.stream()
					  .sorted((o1, o2) -> o1.getDoctorName().compareToIgnoreCase(o2.getDoctorName()))
					  .collect(Collectors.toList());
	}

	@Override
	public List<Doctor> getBySpeciality(String speciality) {
		List<Doctor> doctors = doctorRepository.findBySpeciality(speciality);
		
		if (doctors.isEmpty())
			throw new DoctorNotFoundException("Doctors not available.");
		
		return doctors.stream()
					  .sorted((o1, o2) -> o1.getDoctorName().compareToIgnoreCase(o2.getDoctorName()))
					  .collect(Collectors.toList());
	}

	@Override
	public List<Doctor> getBySpecialityAndExperience(String speciality, int experience) {
		List<Doctor> doctors = doctorRepository.findBySpecialityAndExperience(speciality, experience);
		
		if (doctors.isEmpty())
			throw new DoctorNotFoundException("Doctors not available.");
		
		return doctors.stream()
					  .sorted((o1, o2) -> o1.getDoctorName().compareToIgnoreCase(o2.getDoctorName()))
					  .collect(Collectors.toList());
	}

	@Override
	public List<Doctor> getBySpecialityAndFees(String speciality, double fees) {
		List<Doctor> doctors = doctorRepository.findBySpecialityAndFees(speciality, fees);
		
		if (doctors.isEmpty())
			throw new DoctorNotFoundException("Doctors not available.");
		
		return doctors.stream()
					  .sorted((o1, o2) -> o1.getDoctorName().compareToIgnoreCase(o2.getDoctorName()))
					  .collect(Collectors.toList());
	}

	@Override
	public List<Doctor> getByAvailability(LocalDateTime startTime) {
		List<Doctor> doctors = doctorRepository.findByAvailability(startTime);
		
		if (doctors.isEmpty())
			throw new DoctorNotFoundException("Doctors not available.");
		
		return doctors.stream()
					  .sorted((o1, o2) -> o1.getDoctorName().compareToIgnoreCase(o2.getDoctorName()))
					  .collect(Collectors.toList());
	}

	@Override
	public Doctor getByID(int doctorId) {
		Doctor result = doctorRepository.findById(doctorId).get();
		
		if (result == null)
			throw new IDNotFoundException("The given doctor ID is not available");
		
		return result;
	}

	@Override
	public void deleteDoctor(int doctorId) {
		doctorRepository.deleteById(doctorId);
	}
}
