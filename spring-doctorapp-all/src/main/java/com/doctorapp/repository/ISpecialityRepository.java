package com.doctorapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doctorapp.model.Speciality;

@Repository
public interface ISpecialityRepository extends JpaRepository<Speciality, Integer> {
	@Query("from Speciality s inner join s.doctors d where d.doctorName=?1")
	List<Speciality> findByDoctor(String doctorName);

	@Query(value="select * from hospital h inner join doctor d where h.hospitalName=?1 and d.doctorName=?2",nativeQuery=true)
	List<Speciality> findByHospitalAndDoctor(String hospital, String doctor);
}
