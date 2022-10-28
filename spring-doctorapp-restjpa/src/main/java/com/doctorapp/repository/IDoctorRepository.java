package com.doctorapp.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doctorapp.model.Doctor;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Integer>{
	
	@Query("from Doctor where speciality=?1")
	List<Doctor> findBySpeciality(String speciality);

	@Query("from Doctor where speciality=?1 and experience>=?2")
	List<Doctor> findBySpecialityAndExperience(String speciality, int experience);

	@Query("from Doctor where speciality=?1 and fees<=?2")
	List<Doctor> findBySpecialityAndFees(String speciality, double fees);
	
	@Query("from Doctor where startTime=?1")
	List<Doctor> findByAvailability(LocalDateTime startTime);

}
