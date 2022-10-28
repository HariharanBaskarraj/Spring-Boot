package com.doctorapp.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctorapp.dao.IDoctorDao;
import com.doctorapp.model.Doctor;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	IDoctorDao doctorDao;
	
	public DoctorServiceImpl(IDoctorDao doctorDao) {
		super();
		this.doctorDao = doctorDao;
	}

	@Override
	public void addDoctor(Doctor doctor) {
		doctorDao.addDoctor(doctor);
	}

	@Override
	public void updateDoctor(int doctorId, double fees) {
		doctorDao.updateDoctor(doctorId, fees);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		List<Doctor> doctors = doctorDao.findAllDoctors();
		
		if (doctors.isEmpty())
			throw new DoctorNotFoundException("Doctors not available.");
		
		return doctors.stream()
					  .sorted((o1, o2) -> o1.getDoctorName().compareToIgnoreCase(o2.getDoctorName()))
					  .collect(Collectors.toList());
	}

	@Override
	public List<Doctor> getBySpeciality(String speciality) {
		List<Doctor> doctors = doctorDao.findBySpeciality(speciality);
		
		if (doctors.isEmpty())
			throw new DoctorNotFoundException("Doctors not available.");
		
		return doctors.stream()
					  .sorted((o1, o2) -> o1.getDoctorName().compareToIgnoreCase(o2.getDoctorName()))
					  .collect(Collectors.toList());
	}

	@Override
	public List<Doctor> getBySpecialityAndExperience(String speciality, int experience) {
		List<Doctor> doctors = doctorDao.findBySpecialityAndExperience(speciality, experience);
		
		if (doctors.isEmpty())
			throw new DoctorNotFoundException("Doctors not available.");
		
		return doctors.stream()
					  .sorted((o1, o2) -> o1.getDoctorName().compareToIgnoreCase(o2.getDoctorName()))
					  .collect(Collectors.toList());
	}

	@Override
	public List<Doctor> getBySpecialityAndFees(String speciality, double fees) {
		List<Doctor> doctors = doctorDao.findBySpecialityAndFees(speciality, fees);
		
		if (doctors.isEmpty())
			throw new DoctorNotFoundException("Doctors not available.");
		
		return doctors.stream()
					  .sorted((o1, o2) -> o1.getDoctorName().compareToIgnoreCase(o2.getDoctorName()))
					  .collect(Collectors.toList());
	}

	@Override
	public List<Doctor> getByAvailability(LocalDateTime startTime) {
		List<Doctor> doctors = doctorDao.findByAvailability(startTime);
		
		if (doctors.isEmpty())
			throw new DoctorNotFoundException("Doctors not available.");
		
		return doctors.stream()
					  .sorted((o1, o2) -> o1.getDoctorName().compareToIgnoreCase(o2.getDoctorName()))
					  .collect(Collectors.toList());
	}

	@Override
	public Doctor getByID(int doctorId) {
		Doctor result = doctorDao.findByID(doctorId);
		
		if (result == null)
			throw new IDNotFoundException("The given doctor ID is not available");
		
		return result;
	}

	@Override
	public void deleteDoctor(int doctorId) {
		doctorDao.deleteDoctor(doctorId);
	}
}
