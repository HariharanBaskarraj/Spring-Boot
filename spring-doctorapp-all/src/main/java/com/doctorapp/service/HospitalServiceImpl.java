package com.doctorapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctorapp.model.Hospital;
import com.doctorapp.repository.IHospitalRepository;

@Service
public class HospitalServiceImpl implements IHospitalService {

	private IHospitalRepository hospitalRepository;
	@Autowired
	public void setHospitalRepository(IHospitalRepository hospitalRepository) {
		this.hospitalRepository = hospitalRepository;
	}

	@Override
	public void addHospital(Hospital hospital) {
		hospitalRepository.save(hospital);
	}

	@Override
	public void updateHospital(Hospital hospital) {
		hospitalRepository.save(hospital);
	}

	@Override
	public Hospital getById(int hospitalId) {
		return hospitalRepository.findById(hospitalId).get();
	}

	@Override
	public void deleteHospital(int hospitalId) {
		hospitalRepository.deleteById(hospitalId);
	}

	@Override
	public List<Hospital> getAll() {
		// TODO Auto-generated method stub
		return hospitalRepository.findAll();
	}

	@Override
	public List<Hospital> getByCity(String city) {
		// TODO Auto-generated method stub
		return hospitalRepository.findByCity(city);
	}

	@Override
	public List<Hospital> getBySpecialityAndCity(String speciality, String city) {
		// TODO Auto-generated method stub
		return hospitalRepository.findBySpecialityAndCity(speciality, city);
	}

	@Override
	public List<Hospital> getBySpeciality(String speciality) {
		// TODO Auto-generated method stub
		return hospitalRepository.findBySpeciality(speciality);
	}

	@Override
	public List<Hospital> getBySpecialityAndExp(String speciality, int experience) {
		// TODO Auto-generated method stub
		return hospitalRepository.findBySpecialityAndExp(speciality, experience);
	}

	@Override
	public List<Hospital> getByDoctor(String doctorName) {
		// TODO Auto-generated method stub
		return hospitalRepository.findByDoctor(doctorName);
	}

	@Override
	public List<Hospital> getBySpecialityAndDoctor(String speciality, String doctor) {
		// TODO Auto-generated method stub
		return hospitalRepository.findBySpecialityAndDoctor(speciality, doctor);
	}

	@Override
	public List<Hospital> getByHospital(String hospitalName) {
		// TODO Auto-generated method stub
		return hospitalRepository.findByHospitalName(hospitalName);
	}

}
