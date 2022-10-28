/**
 * 
 */
package com.studentapp.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author HariharanB
 *
 */


@Entity
@Table(name = "Biaddress")
public class Address {
	@Id
	@GeneratedValue(generator ="bi_address_gen",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="bi_address_gen",sequenceName = "bi_address_seq", initialValue=201, allocationSize=1)
	private Integer addressId;
	
	@Column(name="flat", length =5)
	private String flatNumber;
	
	@Column(name="street")
	private String streetName;
	
	@Column(length=25)
	private String city;
	
	@Column(length=20)
	private String state;
	
	@OneToOne(mappedBy="address")
	private Student student;

	public Address() {
		super();
	}

	public Address(String flatNumber, String streetName, String city, String state) {
		super();
		this.flatNumber = flatNumber;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", flatNumber=" + flatNumber + ", streetName=" + streetName
				+ ", city=" + city + ", state=" + state + "]";
	}
}
