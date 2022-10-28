/**
 * 
 */
package com.studentapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.studentapp.model.Student;

/**
 * @author HariharanB
 *
 */
@Repository
public interface IStudentRepository extends JpaRepository<Student,Integer>{
	
	List<Student> findByDepartment(String department);
	
	List<Student> findByAddressCity(String city);
	
	@Query("from Student s inner join s.address a where a.city=?1") //address is the property name
	List<Student> findByCity(String city);
	
	@Query("from Student s inner join s.address a where a.city=?1 and s.department=?2")
	List<Student> findByCityAndDepartment(String city, String department);
	
	@Query("from Student s inner join s.address a where a.city=?1 and a.state=?2")
	List<Student> findByCityState(String city, String state);
}
