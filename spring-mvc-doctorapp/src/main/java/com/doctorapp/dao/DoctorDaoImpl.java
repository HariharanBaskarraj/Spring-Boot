package com.doctorapp.dao;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.doctorapp.model.Doctor;
import com.doctorapp.util.DoctorMapper;
import com.doctorapp.util.Queries;

@Repository
public class DoctorDaoImpl implements IDoctorDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addDoctor(Doctor doctor) {
		Object[] doctorArray = { doctor.getDoctorName(), doctor.getSpeciality(), doctor.getFees(),
				doctor.getExperience(), Timestamp.valueOf(doctor.getStartTime()),
				Timestamp.valueOf(doctor.getEndTime()) };
		jdbcTemplate.update(Queries.INSERTQUERY, doctorArray);
	}

	@Override
	public void updateDoctor(int doctorId, double fees) {
		jdbcTemplate.update(Queries.UPDATEQUERY, fees, doctorId);
	}

	@Override
	public Doctor findByID(int doctorId) {
		return jdbcTemplate.queryForObject(Queries.QUERYBYID, (rs, num) -> {
			Doctor doctor = new Doctor();
			doctor.setDoctorId(rs.getInt("DoctorID"));
			doctor.setDoctorName(rs.getString("DoctorName"));
			doctor.setSpeciality(rs.getString("Speciality"));
			doctor.setFees(rs.getDouble("Fees"));
			doctor.setExperience(rs.getInt("Experience"));
			doctor.setStartTime(rs.getTimestamp("InTime").toLocalDateTime());
			doctor.setEndTime(rs.getTimestamp("OutTime").toLocalDateTime());
			return doctor;
		}, doctorId);
	}

	@Override
	public void deleteDoctor(int doctorId) {
		jdbcTemplate.update(Queries.DELETEQUERY, doctorId);

	}

	@Override
	public List<Doctor> findAllDoctors() {
		return jdbcTemplate.query(Queries.SELECTQUERY, new DoctorMapper());
	}

	@Override
	public List<Doctor> findBySpeciality(String speciality) {
		return jdbcTemplate.query(Queries.QUERYBYSPEC, new DoctorMapper(),speciality);
	}

	@Override
	public List<Doctor> findBySpecialityAndExperience(String speciality, int experience) {
		return  jdbcTemplate.query(Queries.QUERYBYSPECANDEXP, new DoctorMapper(),speciality,experience);
	}

	@Override
	public List<Doctor> findBySpecialityAndFees(String speciality, double fees) {
		return  jdbcTemplate.query(Queries.QUERYBYSPECANDFEE, new DoctorMapper(),speciality,fees);
	}

	@Override
	public List<Doctor> findByAvailability(LocalDateTime startTime) {
		return  jdbcTemplate.query(Queries.QUERYBYAVAIL, new DoctorMapper(),startTime);
	}

}
