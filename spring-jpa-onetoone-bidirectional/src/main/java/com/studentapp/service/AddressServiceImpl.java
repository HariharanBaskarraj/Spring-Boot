/**
 * 
 */
package com.studentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentapp.model.Address;
import com.studentapp.repository.IAddressRepository;

/**
 * @author HariharanB
 *
 */
@Service
public class AddressServiceImpl implements IAddressService {
	
	private IAddressRepository addressRepository;
	@Autowired
	public void setAddressRepository(IAddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}
	
	@Override
	public List<Address> getByName(String studentName) {
		return addressRepository.findByStudentStudentName(studentName);
	}

	@Override
	public List<Address> getByDepartment(String department) {
		return addressRepository.findByStudentDepartment(department);
	}

	@Override
	public List<Address> getByNameAndCity(String studentName, String city) {
		return addressRepository.findByStudentNameCity(studentName, city);
	}

	@Override
	public Address getByStudentId(int studentId) {
		return addressRepository.findByStudentId(studentId);
	}

	@Override
	public List<Address> getNameAndStreet(String studentName, String street) {
		return addressRepository.findNameAndStreet(studentName, street);
	}

	@Override
	public List<Address> getByCity(String city) {
		return addressRepository.findByCity(city);
	}

}
