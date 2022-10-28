/**
 * 
 */
package com.employee.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

/**
 * @author HariharanB
 *
 */
@Entity
public class Course {
	private String courseName;

	@Id
	@GeneratedValue(generator = "course_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "course_gen", sequenceName = "course_seq", initialValue = 201, allocationSize = 1)
	private Integer courseId;
//	@Enumerated(EnumType.STRING)
	private String category;
//	@Enumerated(EnumType.STRING)
	private String mode;
	@ManyToMany(mappedBy = "courses")
	private Set<Employee> employees;

	public Course() {
		super();
	}

	public Course(String courseName, String category, String mode) {
		super();
		this.courseName = courseName;
		this.category = category;
		this.mode = mode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", courseId=" + courseId + ", category=" + category + ", mode="
				+ mode + "]";
	}

}
