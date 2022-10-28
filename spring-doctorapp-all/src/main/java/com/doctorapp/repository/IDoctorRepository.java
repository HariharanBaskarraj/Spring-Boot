package com.doctorapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doctorapp.model.Casesheet;
import com.doctorapp.model.Doctor;
@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {

	Doctor findByCasesheet(Casesheet casesheet);
	
	@Query("from Doctor d inner join d.address a where a.city=?1")
	List<Doctor> findByCity(String city);

	@Query("from Doctor d inner join d.speciality s inner join d.address a where s.specialityName=?1 and a.city=?2")
	List<Doctor> findBySpecialityAndCity(String speciality, String city);
	
	@Query("from Doctor d inner join d.speciality s where s.specialityName=?1")
	List<Doctor> findBySpeciality(String speciality);

	@Query("from Doctor d inner join d.speciality s where s.specialityName=?1 and d.experience>=?2")
	List<Doctor> findBySpecialityAndExperience(String speciality, int experience);

	@Query("from Doctor d inner join d.speciality s where s.specialityName=?1 and d.fees>=?2")
	List<Doctor> findBySpecialityAndFees(String speciality, double fees);

	@Query("from Doctor d inner join d.speciality s inner join d.hospital h where s.specialityName=?1 and h.hospitalName=?2")
	List<Doctor> findBySpecialityAndHospital(String speciality, String hospitalName);

	@Query("from Doctor d inner join d.hospital h where h.hospitalName=?1")
	List<Doctor> findByHospital(String hospitalName);

}
