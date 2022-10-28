package com.doctorapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Casesheet {

	@Id
	@GeneratedValue(generator = "casesheet_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "casesheet_gen", sequenceName = "casesheet_seq", initialValue = 501, allocationSize = 1)
	private Integer caseId;
	private String caseType;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name ="doctor_id")
	Doctor doctor;

	public Casesheet() {
		super();
	}

	public Casesheet(String caseType) {
		super();
		this.caseType = caseType;
	}

	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public String getCaseType() {
		return caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Casesheet [caseId=" + caseId + ", caseType=" + caseType + "]";
	}

}
