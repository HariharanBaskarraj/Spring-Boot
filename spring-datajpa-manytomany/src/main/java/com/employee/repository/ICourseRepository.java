/**
 * 
 */
package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.model.Course;

/**
 * @author HariharanB
 *
 */
@Repository
public interface ICourseRepository extends JpaRepository<Course, Integer> {

	@Query("from Course c inner join c.employees e where e.city=?1")
	List<Course> findByCity(String city);
	
	@Query("from Course c inner join c.employees e where e.name=?1")
	List<Course> findByEmployee(String name);

	@Query("from Course c inner join c.employees e where c.category=?1 and c.mode=?2")
	List<Course> findByCategoryMode(String category, String mode);

//	@Query("from Course c inner join c.Employee e where c.category=?1")
	List<Course> findByCategory(String category);
}
