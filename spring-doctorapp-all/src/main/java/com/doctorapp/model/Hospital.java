package com.doctorapp.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Hospital {

	@Id
	@GeneratedValue(generator = "hospital_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "hospital_gen", sequenceName = "hospital_seq", initialValue = 401, allocationSize = 1)
	private Integer hospitalId;
	private String hospitalName;
	private String city;
	@JsonIgnore
	@OneToMany (mappedBy="hospital", fetch = FetchType.EAGER)
	private Set<Doctor> doctors;

	public Hospital() {
		super();
	}

	public Hospital(String hospitalName, String city) {
		super();
		this.hospitalName = hospitalName;
		this.city = city;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}

	@Override
	public String toString() {
		return "Hospital [hospitalName=" + hospitalName + ", city=" + city + "]";
	}

}
