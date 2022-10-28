/**
 * 
 */
package com.studentapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.studentapp.model.Address;

/**
 * @author HariharanB
 *
 */
@Repository
public interface IAddressRepository extends JpaRepository<Address, Integer> {
	
	List<Address> findByStudentStudentName(String studentName);
	
	List<Address> findByStudentDepartment(String department);
	
	@Query("from Address a inner join a.student s where a.city=?2 and s.studentName=?1")	
	List<Address> findByStudentNameCity(String studentName,String city);
	
	@Query("from Address a inner join a.student s where s.studentId=?1")
	Address findByStudentId(int studentId);

	@Query("from Address a inner join a.student s where s.studentName=?1 and a.streetName=?2")
	List<Address> findNameAndStreet(String studentName, String street);
	
	@Query("from Address a inner join a.student s where a.city=?1")
	List<Address> findByCity(String city);
}
