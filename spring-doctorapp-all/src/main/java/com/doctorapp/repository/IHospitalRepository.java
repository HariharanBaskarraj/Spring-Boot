package com.doctorapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doctorapp.model.Hospital;

@Repository
public interface IHospitalRepository extends JpaRepository<Hospital, Integer> {

	List<Hospital> findByCity(String city);

	@Query(value = "select h.hospital_id,h.hospital_name,h.city,s.speciality_name from hospital h inner join speciality s inner join doctor_speciality ds where ds.speciality_id=s.speciality_id and s.speciality_name=?1 and h.city=?2", nativeQuery = true)
	List<Hospital> findBySpecialityAndCity(String speciality, String city);

	@Query(value = "select h.hospital_id,h.hospital_name,h.city,s.speciality_name from hospital h inner join speciality s inner join doctor_speciality ds where ds.speciality_id=s.speciality_id and s.speciality_name=?1", nativeQuery = true)
	List<Hospital> findBySpeciality(String speciality);

	@Query(value = "select h.hospital_id,h.hospital_name,h.city,s.speciality_name from hospital h inner join speciality s inner join doctor d inner join doctor_speciality ds where ds.speciality_id=s.speciality_id and s.speciality_name=?1 and d.experience=?2", nativeQuery = true)
	List<Hospital> findBySpecialityAndExp(String speciality, int experience);

	@Query("from Hospital h inner join h.doctors d where d.doctorName=?1")
	List<Hospital> findByDoctor(String doctorName);

	@Query(value = " select h.hospital_id,h.hospital_name,h.city,s.speciality_name from hospital h inner join speciality s inner join doctor d inner join doctor_speciality ds where ds.speciality_id=s.speciality_id and s.speciality_name=?1 and d.doctor_name=?2;", nativeQuery = true)
	List<Hospital> findBySpecialityAndDoctor(String speciality, String doctor);

	List<Hospital> findByHospitalName(String hospitalName);
}
