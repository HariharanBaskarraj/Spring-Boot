package com.doctorapp.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Speciality {

	@Id
	@GeneratedValue(generator = "speciality_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "speciality_gen", sequenceName = "speciality_seq", initialValue = 301, allocationSize = 1)
	private Integer specialityId;
	private String specialityName;
	@JsonIgnore
	@ManyToMany(mappedBy = "speciality")
	private Set<Doctor> doctors;

	public Speciality() {
		super();
	}

	public Speciality(String specialityName) {
		super();
		this.specialityName = specialityName;
	}

	public Integer getSpecialityId() {
		return specialityId;
	}

	public void setSpecialityId(Integer specialityId) {
		this.specialityId = specialityId;
	}

	public String getSpecialityName() {
		return specialityName;
	}

	public void setSpecialityName(String specialityName) {
		this.specialityName = specialityName;
	}

	public Set<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}

	@Override
	public String toString() {
		return "Speciality [specialityId=" + specialityId + ", specialityName=" + specialityName + "]";
	}

}
