/**
 * 
 */
package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Course;
import com.employee.repository.ICourseRepository;

/**
 * @author HariharanB
 *
 */
@Service
public class CourseServiceImpl implements ICourseService {

	private ICourseRepository courseRepository;
	@Autowired
	public void setCourseRepository(ICourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@Override
	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public void updateCourse(Course course) {
		courseRepository.save(course);
	}

	@Override
	public void deleteCourse(int courseId) {
		courseRepository.deleteById(courseId);
	}

	@Override
	public List<Course> getAll() {
		return courseRepository.findAll();
	}

	@Override
	public Course getById(int courseId) {
		return courseRepository.findById(courseId).get();
	}

	@Override
	public List<Course> getByCity(String city) {
		return courseRepository.findByCity(city);
	}

	@Override
	public List<Course> getByEmployee(String name) {
		return courseRepository.findByEmployee(name);
	}

	@Override
	public List<Course> getByCategoryMode(String category, String model) {
		return courseRepository.findByCategoryMode(category, model);
	}

	@Override
	public List<Course> getByCategory(String category) {
		return courseRepository.findByCategory(category);
	}

}
