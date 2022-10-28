package com.doctorapp.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.doctorapp.model.Doctor;

public class DoctorMapper implements RowMapper<Doctor> {

	@Override
	public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Doctor doctor =new Doctor();
		doctor.setDoctorId(rs.getInt("DoctorID"));
		doctor.setDoctorName(rs.getString("DoctorName"));
		doctor.setSpeciality(rs.getString("Speciality"));
		doctor.setFees(rs.getDouble("Fees"));
		doctor.setExperience(rs.getInt("Experience"));
		doctor.setStartTime(rs.getTimestamp("InTime").toLocalDateTime());
		doctor.setEndTime(rs.getTimestamp("OutTime").toLocalDateTime());
		return doctor;
	}

}
