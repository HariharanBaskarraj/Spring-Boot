package com.doctorapp.model;

public class Doctor {
	private String doctorName;
	private Integer doctorId;
	private String speciality;
	private double fees;

	public Doctor() {
		super();
	}

	public Doctor(String doctorName, Integer doctorId, String speciality, double fees) {
		super();
		this.doctorName = doctorName;
		this.doctorId = doctorId;
		this.speciality = speciality;
		this.fees = fees;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "Doctor [doctorName=" + doctorName + ", doctorId=" + doctorId + ", speciality=" + speciality + ", fees="
				+ fees + "]";
	}

}
