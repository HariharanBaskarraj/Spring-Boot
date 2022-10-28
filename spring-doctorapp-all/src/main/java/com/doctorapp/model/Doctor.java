package com.doctorapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 * @author HariharanB
 *
 */
@Entity
public class Doctor {

	private String doctorName;
	@Id
	@GeneratedValue(generator = "doctor_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "doctor_gen", sequenceName = "doctor_seq", initialValue = 101, allocationSize = 1)
	private Integer doctorId;
//	@Column(unique = true)
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "doctor_speciality", joinColumns = @JoinColumn(name = "doctor_id"), inverseJoinColumns = @JoinColumn(name = "speciality_id"))
	private Set<Speciality> speciality;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name="hospital_id")
	private Hospital hospital;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name="doctor_id")
	private Set<Casesheet> casesheet;
	private double fees;
	private int experience;

	public Doctor() {
		super();
	}

	/**
	 * @param doctorName
	 * @param email
	 * @param fees
	 * @param experience
	 */
	public Doctor(String doctorName, String email, double fees, int experience,  Address address) {
		super();
		this.doctorName = doctorName;
		this.email = email;
		this.address = address;
		this.fees = fees;
		this.experience = experience;
	}

	/**
	 * @return
	 */
	public String getDoctorName() {
		return doctorName;
	}

	/**
	 * @param doctorName
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	/**
	 * @return
	 */
	public Integer getDoctorId() {
		return doctorId;
	}

	/**
	 * @param doctorId
	 */
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return
	 */
	public Hospital getHospital() {
		return hospital;
	}

	/**
	 * @param hospital
	 */
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	/**
	 * @return
	 */
	public Set<Speciality> getSpeciality() {
		return speciality;
	}

	/**
	 * @param speciality
	 */
	public void setSpeciality(Set<Speciality> speciality) {
		this.speciality = speciality;
	}

	/**
	 * @return
	 */
	public Set<Casesheet> getCasesheet() {
		return casesheet;
	}

	/**
	 * @param casesheet
	 */
	public void setCasesheet(Set<Casesheet> casesheet) {
		this.casesheet = casesheet;
	}

	/**
	 * @return
	 */
	public double getFees() {
		return fees;
	}

	/**
	 * @param fees
	 */
	public void setFees(double fees) {
		this.fees = fees;
	}

	/**
	 * @return
	 */
	public int getExperience() {
		return experience;
	}

	/**
	 * @param experience
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}

	
	@Override
	public String toString() {
		return "Doctor [doctorName=" + doctorName + ", doctorId=" + doctorId + ", email=" + email + ", fees=" + fees
				+ ", experience=" + experience + "]";
	}

}
