/**
 * 
 */
package com.employee.service;

import java.util.List;

import com.employee.model.Course;

/**
 * @author HariharanB
 *
 */
public interface ICourseService {

	Course addCourse(Course Course);
	void updateCourse(Course Course);
	void deleteCourse(int courseId);
	List<Course> getAll();
	Course getById(int courseId);
	
	//derived
	List<Course> getByCity(String city);
	List<Course> getByEmployee(String name);
	List<Course> getByCategoryMode(String category, String mode);
	List<Course> getByCategory(String category);
}
