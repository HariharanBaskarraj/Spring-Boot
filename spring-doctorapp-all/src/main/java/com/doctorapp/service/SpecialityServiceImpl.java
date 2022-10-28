package com.doctorapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctorapp.model.Speciality;
import com.doctorapp.repository.ISpecialityRepository;

@Service
public class SpecialityServiceImpl implements ISpecialityService {

	private ISpecialityRepository specialityRepository;
	@Autowired
	public void setSpecialityRepository(ISpecialityRepository specialityRepository) {
		this.specialityRepository = specialityRepository;
	}

	@Override
	public void addSpeciality(Speciality speciality) {
		specialityRepository.save(speciality);
	}

	@Override
	public void updateSpeciality(Speciality speciality) {
		specialityRepository.save(speciality);

	}

	@Override
	public Speciality getById(int specialityId) {
		return specialityRepository.findById(specialityId).get();
	}

	@Override
	public void deleteSpeciality(int specialityId) {
		specialityRepository.deleteById(specialityId);
	}

	@Override
	public List<Speciality> getAll() {
		return specialityRepository.findAll();
	}

	@Override
	public List<Speciality> getByDoctor(String doctorName) {
		// TODO Auto-generated method stub
		return specialityRepository.findByDoctor(doctorName);
	}

	@Override
	public List<Speciality> getByHospitalAndDoctor(String hospital, String doctor) {
		// TODO Auto-generated method stub
		return specialityRepository.findByHospitalAndDoctor(hospital, doctor);
	}

}
