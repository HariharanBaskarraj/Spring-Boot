/**
 * 
 */
package com.studentapp.service;

import java.util.List;

import com.studentapp.model.Address;

/**
 * @author HariharanB
 *
 */
public interface IAddressService {
	
	List<Address> getByName(String studentName);
	
	List<Address> getByDepartment(String department);
	
	List<Address> getByNameAndCity(String studentName,String city);
	
	Address getByStudentId(int studentId);
	
	List<Address> getNameAndStreet(String studentName, String street);
	
	List<Address> getByCity(String city);
	
}
