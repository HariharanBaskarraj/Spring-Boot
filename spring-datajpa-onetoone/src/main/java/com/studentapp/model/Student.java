/**
 * 
 */
package com.studentapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * @author HariharanB
 *
 */
@Entity
//@Table(name = "newStudent")
public class Student {
	@Id
	@GeneratedValue(generator = "student_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "student_gen", sequenceName = "student_seq", initialValue = 101, allocationSize = 1)
	private Integer studentId;

	@Column(length = 35)
	private String studentName;

	@Column(length = 20, nullable = false)
	private String department;

	@Column(length = 50, unique = true)
	private String email;

	@OneToOne
	@Cascade(value = CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;

	public Student() {
		super();
	}

	public Student(String studentName, String department, String email, Address address) {
		super();
		this.studentName = studentName;
		this.department = department;
		this.email = email;
		this.address = address;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", department=" + department
				+ ", email=" + email + ", address=" + address + "]";
	}

}
